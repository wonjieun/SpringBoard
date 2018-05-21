package mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.MemberDao;
import mvc.dto.Writer;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDao memberDao;
	
	@Override
	public boolean join(Writer writer) {
		if(memberDao.selectByUserid(writer)>0)
			return false;
		
		memberDao.join(writer);
		
		if(memberDao.selectByUserid(writer)>0)
			return true;
		else return false;
	}

	@Override
	public boolean login(Writer writer) {
		int loginChk = memberDao.login(writer);
		
		if(loginChk > 0)	return true;
		else return false;
	}

	@Override
	public String getUsernick(Writer writer) {
		return memberDao.getUsernick(writer);
	}

	
}













