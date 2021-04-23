package com.laptrinhjavaweb.ultils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class formUltils {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tclass, HttpServletRequest requets ) {
		T object =null;
		try {
			object  =tclass.newInstance();
			BeanUtils.populate(object, requets.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;
	}
}
