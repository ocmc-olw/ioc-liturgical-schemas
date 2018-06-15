package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.ocmc.ioc.liturgical.schemas.id.managers.IdManager;
import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;
import org.ocmc.ioc.liturgical.schemas.models.ws.forms.DomainCreateForm;

import com.google.gson.JsonArray;

public class USER_INTERFACE_DOMAINS {
    private static  Map<String, String> map = new TreeMap<String,String>();
    static {
		map.put("alb_sys_ilr", "User Interface - Core - Albanian - Shqiptar");
		map.put("ara_sys_ilr", "User Interface - Core - Arabic - عربى");
		map.put("zh_sys_ilr", "User Interface - Core - Chinese - 中文");
		map.put("en_sys_ilr", "User Interface - Core - English");
		map.put("fil_sys_ilr", "User Interface - Core - Filipino");
		map.put("fra_sys_ilr", "User Interface - Core - French - Français");
		map.put("el_sys_ilr", "User Interface - Core - Greek - Ελληνικά");
		map.put("ind_sys_ilr", "User Interface - Core - Indonesian - Bahasa Indonesia");
		map.put("jpn_sys_ilr", "User Interface - Core - Japanese - 日本語");
		map.put("kor_sys_ilr", "User Interface - Core - Korean - 한국어");
		map.put("mon_sys_ilr", "User Interface - Core - Mongolian - Монгол хэл");
		map.put("rus_sys_ilr", "User Interface - Core - Russian - Русский");
		map.put("spa_sys_ilr", "User Interface - Core - Spanish - Español");
		map.put("swh_sys_ilr", "User Interface - Core - Swahili - Kiswahili");
		map.put("alb_sys_olw", "User Interface - OLW - Albanian - Shqiptar");
		map.put("ara_sys_olw", "User Interface - OLW - Arabic - عربى");
		map.put("zh_sys_olw", "User Interface - OLW - Chinese - 中文");
		map.put("en_sys_olw", "User Interface - OLW - English");
		map.put("fil_sys_olw", "User Interface - OLW - Filipino");
		map.put("fra_sys_olw", "User Interface - OLW - French - Français");
		map.put("el_sys_olw", "User Interface - OLW - Greek - Ελληνικά");
		map.put("ind_sys_olw", "User Interface - OLW - Indonesian - Bahasa Indonesia");
		map.put("jpn_sys_olw", "User Interface - OLW - Japanese - 日本語");
		map.put("mon_sys_olw", "User Interface - OLW - Mongolian - Монгол хэл");
		map.put("kor_sys_olw", "User Interface - OLW - Korean - 한국어");
		map.put("rus_sys_olw", "User Interface - OLW - Russian - Русский");
		map.put("spa_sys_olw", "User Interface - OLW - Spanish - Español");
		map.put("swh_sys_olw", "User Interface - OLW - Swahili - Kiswahili");
	}
    
    public static boolean containsKey(String key) {
    	return map.containsKey(key);
    }
    
    public static String get(String key) {
    	return key + " - " + map.get(key);
    }
    
    public static String getLabel(String key) {
    	if (map.containsKey(key)) {
    		return get(key);
    	} else {
    		return key;
    	}
    }
    
    public static Map<String,String> getMap() {
    	return map;
    }
    
    public static JsonArray toDropdownJsonArray() {
    	JsonArray array = new JsonArray();
    	for (Entry<String,String> entry : map.entrySet()) {
    		array.add(new DropdownItem(entry.getValue(), entry.getKey()).toJsonObject());
    	}
    	return array;
    }

    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (Entry<String,String> entry : map.entrySet()) {
    		result.add(new DropdownItem(entry.getValue(), entry.getKey()));
    	}
    	return result;
    }
    
    public static List<DomainCreateForm> toDomainCreateForms() {
    	List<DomainCreateForm> domains = new ArrayList<DomainCreateForm>();
    	for (Entry<String,String> entry : map.entrySet()) {
        	IdManager idManager = new IdManager();
        	idManager.setLibrary(entry.getKey());
        	DomainCreateForm domain = new DomainCreateForm();
        	domain.setLanguageCode(idManager.getLibraryLanguage());
        	domain.setCountryCode(idManager.getLibraryCountry());
        	domain.setRealm(idManager.getLibraryRealm());
        	domain.setDescription(entry.getValue());
        	domains.add(domain);
    	}
    	return domains;
    }
}
