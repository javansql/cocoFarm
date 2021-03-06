package cocoFarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cocoFarm.dao.ProductDao;
import cocoFarm.dao.SaleOptionDao;
import cocoFarm.dto.Option;
import cocoFarm.dto.Product;
import cocoFarm.dto.SaleOption;
import cocoFarm.util.Paging;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired ProductDao productDao;
	@Autowired SaleOptionDao saleOptionDao;
	
	@Override
	public List getList() {
		return saleOptionDao.selectAll();
	}
	
	@Override
	public int getListCount() {
		// Product 또는 SaleOption 어떤 list를 불러올 것인지
//		return productDao.countAll();
		return saleOptionDao.countAll();
	}
	
	@Override
	public List getPagingList(Paging paging) {
		// Product 또는 SaleOption 어떤 list를 불러올 것인지
//		return productDao.selectPage(paging);
		return saleOptionDao.selectPage(paging);
	}
	
	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}
	
	@Override
	public void insert(Product product, SaleOption saleOption) {
//		System.out.println(product);
//		System.out.println(">>>>>>>>>>>> idx = " + product.getIdx());
		saleOption.setPkIdx(product.getIdx());
		saleOptionDao.insert(saleOption);
		saleOptionDao.insertCategory(saleOption);
	}
	
	@Override
	public Product productView(int saleIdx) {
		return productDao.selectProductByIdx(saleIdx);
	}
	
	@Override
	public List optionView(int saleIdx) {
//		List<SaleOption> saleList = saleOptionDao.selectOptionByIdx(saleIdx);
		return saleOptionDao.selectOptionByIdx(saleIdx);
	}
	
	@Override
	public int optionNumber(int saleIdx) {
		return saleOptionDao.countOption(saleIdx);
	}
	
	@Override
	public void update(Product product, Option Option) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void update(Option option) {
		// saleIdx를 통해 옵션 idx를 얻어 setting
		List<SaleOption> optionIdx = saleOptionDao.selectOptionByIdx(option.getSaleOptions().get(0).getSaleIdx());

		System.out.println("Before optionSize: " + optionIdx.size());
//		System.out.println("Before option [idx1: " + optionIdx.get(0).getIdx() + "]");
//		System.out.println("Before option [idx2: " + optionIdx.get(1).getIdx() + "]");
		System.out.println("--------------");

		int optionSize = option.getSaleOptions().size();
		System.out.println("After optionSize: " + optionSize);
//		System.out.println(option.getSaleOptions().get(0));
//		System.out.println(option.getSaleOptions().get(1));
		
		int i=0;
		// 옵션 제거
		if(optionIdx.size() > optionSize) {
			for(i=optionSize; i<optionIdx.size(); i++) {
				saleOptionDao.delete(optionIdx.get(i));
			}
		// 기존 옵션 수정
		} else if(optionIdx.size() == optionSize) {
			for(i=0; i<optionIdx.size(); i++) {
				option.getSaleOptions().get(i).setIdx(optionIdx.get(i).getIdx());
				saleOptionDao.update(option.getSaleOptions().get(i));
			}
		// 옵션 추가
		} else if(optionIdx.size() < optionSize) {
			for(i=optionIdx.size(); i<optionSize; i++) {
				saleOptionDao.updateNew(option.getSaleOptions().get(i));
			}
		}
	}
	
	@Override
	public void update(Product product) {
		productDao.update(product);
		// 이미지가 등록되었을 경우, 등록되지 않았을 경우(기존 이미지 유지) 나눠서 생각해 본다. 나중에
	}
	
	@Override
	public void insertCart(Option option, int accIdx) {
		SaleOption saleOption = null;
		for(int i=0; i<option.getSaleOptions().size(); i++) {
			System.out.println("SaleOption" + (i+1) + " idx: " + option.getSaleOptions().get(i).getIdx());
			saleOption = saleOptionDao.selectOption(option.getSaleOptions().get(i).getIdx());
			saleOption.setProAmount(option.getSaleOptions().get(i).getProAmount());
			System.out.println("CART SaleOption" + (i+1) + ":" + saleOption);
			saleOptionDao.insertCart(saleOption, accIdx);
		}
	}
	
	//2018_05_26 hwanmin work
	@Override
	public List getProMainList(){
		return productDao.ProMainList();
	}
	
	@Override
	public List getSerchList(Product product){
		return productDao.SerchPro(product);
	}
	//2018_05_26 
	@Override
	public Product getDetailList(Product product) {
		return productDao.getDetailList(product);
	}
	
	@Override
	public List getOptionList(SaleOption saleoption) {
		return productDao.getOptionList(saleoption);
	}
	
	//2018_06_24
	@Override
	public List getOption_amid(Product product, SaleOption saleoption) {
		return null;
	}
	
	@Override
	public List<SaleOption> getPayOption(String query) {
		return productDao.getPayOption(query);
	}
		
	@Override
	public List<Product> getSale_Option(String salequery) {
		return productDao.getSale_Option(salequery);
	}
	
}
