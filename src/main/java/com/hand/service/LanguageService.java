package com.hand.service;

import com.hand.dao.IDAO;
import com.hand.dao.LanguageDao;
import com.hand.dao.impl.LanguageDaoImpl;
import com.hand.entity.Language;

public class LanguageService extends BaseService<Language> {
	
	private static LanguageDao  dao = new LanguageDaoImpl();

	public LanguageService() {
		super(dao);
	}

}
