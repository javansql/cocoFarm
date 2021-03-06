package cocoFarm.dto;

import java.sql.Timestamp;

public class Auction_Inquire {

	
	private Integer idx;			//경매 문의글 번호 - 기본키, 인조식별자 트리거있음
	private Integer autcion_idx;	//경매글 번호 - null불가. 외래키
	private Integer writer_idx;		//문의 계정 번호 - null불가. 외래키
	private String content;			//문의내용 - null불가
	private Timestamp written_time;	//문의글 작성시각 - null불가, 트리거있음(기본값 시스템시간처리)
	private String answer;			//문의글에 대한 답변 - null가능.
	private Timestamp answer_time;	//문의글 답변 시각 - null가능, 트리거있음 (답변 작성시 자동으로 시간 기입)
	private Integer isdel;			//삭제 혹은 이외의(블라인드 따위) 글 상태 - 외래키 null불가 트리거있음 (기본값 0)
	
	public Integer getIdx() {
		return idx;
	}



	public void setIdx(Integer idx) {
		this.idx = idx;
	}



	public Integer getAutcion_idx() {
		return autcion_idx;
	}



	public void setAutcion_idx(Integer autcion_idx) {
		this.autcion_idx = autcion_idx;
	}



	public Integer getWriter_idx() {
		return writer_idx;
	}



	public void setWriter_idx(Integer writer_idx) {
		this.writer_idx = writer_idx;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Timestamp getWritten_time() {
		return written_time;
	}



	public void setWritten_time(Timestamp written_time) {
		this.written_time = written_time;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public Timestamp getAnswer_time() {
		return answer_time;
	}



	public void setAnswer_time(Timestamp answer_time) {
		this.answer_time = answer_time;
	}



	public Integer getIsdel() {
		return isdel;
	}



	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}



	@Override
	public String toString() {
		return "Auction [idx="+idx
				+", autcion_idx="+autcion_idx
				+", writer_idx="+writer_idx
				+", content="+content
				+", written_time="+written_time
				+", answer="+answer
				+", answer_time="+answer_time
				+", isdel="+isdel+"]";
	}


}
