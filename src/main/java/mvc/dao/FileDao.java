package mvc.dao;

import mvc.dto.UploadFile;

public interface FileDao {
	
	/**
	 * Desc : 파일 업로드 기록 
	 * @method : insert
	 * @param uploadFile - 업로드한 파일의 정보
	 * @return : void
	 * @since  : 2018. 5. 4.
	 * @author : user1
	 *
	 */
	public void insert(UploadFile uploadFile);
}
