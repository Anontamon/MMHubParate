package com.actionbarsherlock.widget;

public class MMTokenizer {

	public static String factory(String s){
		if(s.contains("္")){
			s = s.replaceAll("ည္","\u2266");
			s = s.replaceAll("ဋ္","\u2267");
			s = s.replaceAll("ဍ္","\u2268");
			s = s.replaceAll("\u100e္","\u2269");
			s = s.replaceAll("ဏ္","\u2270");
			s = s.replaceAll("တ္","\u2271");
			s = s.replaceAll("ထ္","\u2272");
			s = s.replaceAll("ဒ္","\u2273");
			s = s.replaceAll("ဓ္","\u2274");
			s = s.replaceAll("န္","\u2275");
			s = s.replaceAll("ပ္","\u2276");
			s = s.replaceAll("ဖ္","\u2277");
			s = s.replaceAll("ဗ္","\u2278");
			s = s.replaceAll("ဘ္","\u2279");
			s = s.replaceAll("မ္","\u2280");
			s = s.replaceAll("ယ္","\u2281");
			s = s.replaceAll("ရ္","\u2282");
			s = s.replaceAll("လ္","\u2283");
			s = s.replaceAll("၀္","\u2284");
			s = s.replaceAll("သ္","\u2285");
			s = s.replaceAll("ဟ္","\u2286");
			s = s.replaceAll("\u1020္","\u2287");
			s = s.replaceAll("အ္","\u2288");
			s = s.replaceAll("ဥ္","\u2289");

			s = s.replaceAll("က္","\u2292");
			s = s.replaceAll("ခ္","\u2293");
			s = s.replaceAll("ဂ္","\u2294");
			s = s.replaceAll("ဃ္","\u2295");
			s = s.replaceAll("င္","\u2296");
			s = s.replaceAll("စ္","\u2297");
			s = s.replaceAll("ဆ္","\u2298");

		}

		if(s.contains("ေ")){
			s = s.replaceAll("ေက","\u2290");
			s = s.replaceAll("ေခ","\u2291");
			s = s.replaceAll("ေဂ","\u2299");
			s = s.replaceAll("ေဃ","\u2300");
			s = s.replaceAll("ေင","\u2301");
			s = s.replaceAll("ေစ","\u2302");
			s = s.replaceAll("ေဆ","\u2303");
			s = s.replaceAll("ေဇ","\u2304");

			s = s.replaceAll("ေစ်","\u2305");
			s = s.replaceAll("ေ\u1008","\u2305");

			s = s.replaceAll("ေည","\u2306");
			s = s.replaceAll("ေဋ","\u2307");
			s = s.replaceAll("ေဌ","\u2308");
			s = s.replaceAll("ေဍ","\u2309");
			s = s.replaceAll("ေ\u1020","\u2310");
			s = s.replaceAll("ေဏ","\u2311");
			s = s.replaceAll("ေတ","\u2312");
			s = s.replaceAll("ေထ","\u2313");
			s = s.replaceAll("ေဒ","\u2314");
			s = s.replaceAll("ေဓ","\u2315");
			s = s.replaceAll("ေန","\u2316");
			s = s.replaceAll("ေပ","\u2317");
			s = s.replaceAll("ေဖ","\u2318");
			s = s.replaceAll("ေဗ","\u2319");
			s = s.replaceAll("ေဘ","\u2320");
			s = s.replaceAll("ေမ","\u2321");
			s = s.replaceAll("ေယ","\u2322");
			s = s.replaceAll("ေရ","\u2323");
			s = s.replaceAll("ေလ","\u2324");
			s = s.replaceAll("ေ၀","\u2325");
			s = s.replaceAll("ေဝ","\u2325");
			s = s.replaceAll("ေသ","\u2326");
			s = s.replaceAll("ေဟ","\u2327");
			s = s.replaceAll("ေဠ","\u2328");
			s = s.replaceAll("ေအ","\u2329");
			s = s.replaceAll("ဇ္","\u2330");
			s = s.replaceAll("ေႏ","\u2331");
			s = s.replaceAll("ေ႐","\u2332");
			s = s.replaceAll("ေ\u107e","\u2333");
			s = s.replaceAll("ေ\u103b","\u2334");
			s = s.replaceAll("ေ\u107f","\u2335");
			s = s.replaceAll("ေ\u1080","\u2336");
			s = s.replaceAll("ေ\u1081","\u2337");
			s = s.replaceAll("ေ\u1082","\u2338");
			s = s.replaceAll("ေ\u1083","\u2339");
			s = s.replaceAll("ေ\u1074","\u2340");
		}
		s = s.replace("၀", "ဝ");
		return s;
	}

	public static String defactory(String s){
		s = s.replaceAll("\u2266","ည္");
		s = s.replaceAll("\u2267","ဋ္");
		s = s.replaceAll("\u2268","ဍ္");
		s = s.replaceAll("\u2269","\u100e္");
		s = s.replaceAll("\u2270","ဏ္");
		s = s.replaceAll("\u2271","တ္");
		s = s.replaceAll("\u2272","ထ္");
		s = s.replaceAll("\u2273","ဒ္");
		s = s.replaceAll("\u2274","ဓ္");
		s = s.replaceAll("\u2275","န္");
		s = s.replaceAll("\u2276","ပ္");
		s = s.replaceAll("\u2277","ဖ္");
		s = s.replaceAll("\u2278","ဗ္");
		s = s.replaceAll("\u2279","ဘ္");
		s = s.replaceAll("\u2280","မ္");
		s = s.replaceAll("\u2281","ယ္");
		s = s.replaceAll("\u2282","ရ္");
		s = s.replaceAll("\u2283","လ္");
		s = s.replaceAll("\u2284","၀္");
		s = s.replaceAll("\u2285","သ္");
		s = s.replaceAll("\u2286","ဟ္");
		s = s.replaceAll("\u2287","\u1020္");
		s = s.replaceAll("\u2288","အ္");
		s = s.replaceAll("\u2289","ဥ္");

		s = s.replaceAll("\u2292","က္");
		s = s.replaceAll("\u2293","ခ္");
		s = s.replaceAll("\u2294","ဂ္");
		s = s.replaceAll("\u2295","ဃ္");
		s = s.replaceAll("\u2296","င္");
		s = s.replaceAll("\u2297","စ္");
		s = s.replaceAll("\u2298","ဆ္");

		s = s.replaceAll("\u2290","ေက");
		s = s.replaceAll("\u2291","ေခ");
		s = s.replaceAll("\u2299","ေဂ");
		s = s.replaceAll("\u2300","ေဃ");
		s = s.replaceAll("\u2301","ေင");
		s = s.replaceAll("\u2302","ေစ");
		s = s.replaceAll("\u2303","ေဆ");
		s = s.replaceAll("\u2304","ေဇ");

		s = s.replaceAll("\u2305","ေစ်");
		s = s.replaceAll("\u2305","ေ\u1008");

		s = s.replaceAll("\u2306","ေည");
		s = s.replaceAll("\u2307","ေဋ");
		s = s.replaceAll("\u2308","ေဌ");
		s = s.replaceAll("\u2309","ေဍ");
		s = s.replaceAll("\u2310","ေ\u1020");
		s = s.replaceAll("\u2311","ေဏ");
		s = s.replaceAll("\u2312","ေတ");
		s = s.replaceAll("\u2313","ေထ");
		s = s.replaceAll("\u2314","ေဒ");
		s = s.replaceAll("\u2315","ေဓ");
		s = s.replaceAll("\u2316","ေန");
		s = s.replaceAll("\u2317","ေပ");
		s = s.replaceAll("\u2318","ေဖ");
		s = s.replaceAll("\u2319","ေဗ");
		s = s.replaceAll("\u2320","ေဘ");
		s = s.replaceAll("\u2321","ေမ");
		s = s.replaceAll("\u2322","ေယ");
		s = s.replaceAll("\u2323","ေရ");
		s = s.replaceAll("\u2324","ေလ");
		s = s.replaceAll("\u2325","ေဝ");
		s = s.replaceAll("\u2326","ေသ");
		s = s.replaceAll("\u2327","ေဟ");
		s = s.replaceAll("\u2328","ေဠ");
		s = s.replaceAll("\u2329","ေအ");
		s = s.replaceAll("\u2330","ဇ္");
		s = s.replaceAll("\u2331","ေႏ");
		s = s.replaceAll("\u2332","ေ႐");
		s = s.replaceAll("\u2333","ေ\u107e");
		s = s.replaceAll("\u2334","ေ\u103b");
		s = s.replaceAll("\u2335","ေ\u107f");
		s = s.replaceAll("\u2336","ေ\u1080");
		s = s.replaceAll("\u2337","ေ\u1081");
		s = s.replaceAll("\u2338","ေ\u1082");
		s = s.replaceAll("\u2339","ေ\u1083");
		s = s.replaceAll("\u2340","ေ\u1074");
		return s;
	}
}
