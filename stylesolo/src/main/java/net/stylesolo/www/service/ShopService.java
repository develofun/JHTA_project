package net.stylesolo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ShopDao;

@Service
public class ShopService {
	@Autowired
	private ShopDao shopDao;
}
