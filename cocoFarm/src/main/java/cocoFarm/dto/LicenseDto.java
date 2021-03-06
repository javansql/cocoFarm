package cocoFarm.dto;

import org.springframework.web.multipart.MultipartFile;

public class LicenseDto {

	private String acc_idx;						//회원 IDX(로그인중인,사업자등록을 하려는 회원의 IDX)
	private int business_license_code;			// 사업자번호
	private String business_reg_date;			// 개업년월일
	private String corporation_name;			// 법인명
	private String representative;				// 대표자 이름
	private String business_addr;				// 사업장 소재지 : 주소
	private String business_detailed_addr;		// 사업장 소재지 : 상세주소
	private String headquarter_addr;			// 본점 소재지 : 주소
	private String headquarter_detailed_addr;	// 본점 소재지 : 상세주소
	private String business_category;			// 사업의 종류 : 업태
	private String business_type;				// 사업의 종류 : 종류
	private MultipartFile license_img;			// 사업자등록증 이미지 받아오는 멀티파트파일
	private String license_storedName;			// 사업자등록증 이미지 변환 이름(DB에 저장되는 이름)
	

	public String getBusiness_reg_date() {
		return business_reg_date;
	}

	public void setBusiness_reg_date(String business_geg_date) {
		this.business_reg_date = business_geg_date;
	}

	public String getAcc_idx() {
		return acc_idx;
	}

	public void setAcc_idx(String acc_idx) {
		this.acc_idx = acc_idx;
	}

	public String getLicense_storedName() {
		return license_storedName;
	}

	public void setLicense_storedName(String license_storedName) {
		this.license_storedName = license_storedName;
	}

	public MultipartFile getLicense_img() {
		return license_img;
	}

	public void setLicense_img(MultipartFile license_img) {
		this.license_img = license_img;
	}

	public int getBusiness_license_code() {
		return business_license_code;
	}

	public void setBusiness_license_code(int business_license_code) {
		this.business_license_code = business_license_code;
	}

	public String getCorporation_name() {
		return corporation_name;
	}

	public void setCorporation_name(String corporation_name) {
		this.corporation_name = corporation_name;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getBusiness_addr() {
		return business_addr;
	}

	public void setBusiness_addr(String business_addr) {
		this.business_addr = business_addr;
	}

	public String getBusiness_detailed_addr() {
		return business_detailed_addr;
	}

	public void setBusiness_detailed_addr(String business_detailed_addr) {
		this.business_detailed_addr = business_detailed_addr;
	}

	public String getHeadquarter_addr() {
		return headquarter_addr;
	}

	public void setHeadquarter_addr(String headquarter_addr) {
		this.headquarter_addr = headquarter_addr;
	}

	public String getHeadquarter_detailed_addr() {
		return headquarter_detailed_addr;
	}

	public void setHeadquarter_detailed_addr(String headquarter_detailed_addr) {
		this.headquarter_detailed_addr = headquarter_detailed_addr;
	}

	public String getBusiness_category() {
		return business_category;
	}

	public void setBusiness_category(String business_category) {
		this.business_category = business_category;
	}

	public String getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}


	@Override
	public String toString() {
		return "[License = business_license_code : " + business_license_code
				+ ", business_reg_date : " + business_reg_date
				+ ", corporation_name : " + corporation_name
				+ ", representative : " + representative
				+ ", business_addr : " + business_addr
				+ ", business_detailed_addr : " + business_detailed_addr
				+ ", headquarter_addr : " + headquarter_addr
				+ ", headquarter_detailed_addr : " + headquarter_detailed_addr
				+ ", business_category : " + business_category
				+ ", business_type : " + business_type
				+ ", license_storedName : " + license_storedName
				+ " ]";
		
	}
	
}
