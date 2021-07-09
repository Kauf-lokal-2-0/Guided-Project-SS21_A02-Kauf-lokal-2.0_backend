package com.KaufLokal.KaufLokalApplication;


import com.KaufLokal.KaufLokalApplication.domain.model.*;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import com.KaufLokal.KaufLokalApplication.domain.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class KaufLokalApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaufLokalApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VendorRepository vendorRepository,
								  CouponRepository couponRepository,
								  RatingRepository ratingRepository,
								  UserRepository userRepository,
								  ProductRepository productRepository,
								  MessageRepository messageRepository,
								  EventRepository eventRepository
	) {
		return (args) -> {

			User user_0 = new User();
			user_0.setFirstName("Firstname");
			user_0.setLastName("LastName");
			user_0.setEmail("test@test.de");

			Event event_0 = new Event();
			event_0.setCreated(new Date());
			event_0.setEventTypes(EventTypes.MESSAGE);
			event_0.setCreated(new Date());
			Event event0 = eventRepository.save(event_0);

			Set<Event> eventSet_0 = new HashSet<>();
			eventSet_0.add(event0);

			Set<String> detailImagesMayerscheGummersbach = new HashSet<>();
			detailImagesMayerscheGummersbach.add("https://lh5.googleusercontent.com/p/AF1QipPWXgoi-dUHFzzMMXVTG2mzWMNUrCNBo7nGQMPZ=w1080-k-no");
			detailImagesMayerscheGummersbach.add("https://www.schreibwerkstatt-gm.de/wp-content/gallery/2019-lesung-mayersche/190912-04.JPG");
			detailImagesMayerscheGummersbach.add("https://www.schreibwerkstatt-gm.de/wp-content/gallery/2019-lesung-mayersche/190912-14.JPG");

			Set<String> detailImagesForumGummersbach = new HashSet<>();
			detailImagesForumGummersbach.add("https://www.hbb.de/wp-content/uploads/2020/08/HBB_Gummersbach_header-1024x427.jpeg");
			detailImagesForumGummersbach.add("https://www.prolicht.at/media/2641/prolicht_glorious_sl_neverending_02_forum_gummersbach_2015_hero.jpg?crop=0,0.27740740740740744,0,0.18697337962962962&cropmode=percentage&width=1920&height=865&rnd=131562682170000000");
			detailImagesForumGummersbach.add("https://www.ehs-ingenieure.de/wp-content/uploads/2015/09/bf37dd7ed7.jpg");

			Set<String> detailImagesStreetOneRetailGmbH = new HashSet<>();
			detailImagesStreetOneRetailGmbH.add("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2015/08/Street-One_170927_Forum_Gummersbach_0022-700x466.jpg");
			detailImagesStreetOneRetailGmbH.add("https://www.innenstadt-pinneberg.de/media/1003/innenstadt_pinneberg_rathauspassage_street_one.700.0.jpg");
			detailImagesStreetOneRetailGmbH.add("https://www.forum-hanau.net/wp-content/uploads/sites/3/2015/08/street-one_170630_Forum_Hanau_0153-700x466.jpg");

			Set<String> detailImagesAlanyaRestaurantGummersbach = new HashSet<>();
			detailImagesAlanyaRestaurantGummersbach.add("https://doenerbudenalexhome.files.wordpress.com/2019/05/img_20190420_175238074_burst000_cover.jpg");
			detailImagesAlanyaRestaurantGummersbach.add("https://doenerbudenalexhome.files.wordpress.com/2019/05/img_20190420_173515899_burst001.jpg");
			detailImagesAlanyaRestaurantGummersbach.add("https://doenerbudenalexhome.files.wordpress.com/2019/05/img_20190420_173511011_burst002.jpg");

			Set<String> detailImagesBergischerHof = new HashSet<>();
			detailImagesBergischerHof.add("https://www.news-on-tour.de/wp-content/uploads/2014/06/ekz-bergischer-hof_ntoi_gummersbach.jpg");
			detailImagesBergischerHof.add("https://www.rundschau-online.de/image/36765080/8x3/2000/750/a1890773f4eb6eb27aed77f8d3d993c1/Ic/bergischer-hof3.jpg");

			Set<String> detailImagesEngbers = new HashSet<>();
			detailImagesEngbers.add("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2015/08/engbers_170927_Forum_Gummersbach_0156-700x467.jpg");

			Set<String> detailImagesTakkoFashionGummersbach = new HashSet<>();
			detailImagesTakkoFashionGummersbach.add("https://www.troisdorf.city/var/ezdemo_site/storage/images/unternehmen-geschaefte-mehr/takko-fashion-gmbh/1032151-8-ger-DE/Takko-Fashion-GmbH_koe_eyecatcher.jpg");

			Set<String> detailImagesCecilPartnerStoreGummersbach = new HashSet<>();
			detailImagesCecilPartnerStoreGummersbach.add("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2018/10/Cecil_DSC00427-700x394.jpg");

			Set<String> detailImagesKult = new HashSet<>();
			detailImagesKult.add("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2015/08/Kult_170927_Forum_Gummersbach_0062-700x466.jpg");

			Rating rating_0 = new Rating();
			rating_0.setRatingScore(4.5);
			Rating rating0 = ratingRepository.save(rating_0);
			Set<Rating> ratingsSet_0 = new HashSet<>();
			ratingsSet_0.add(rating0);
			user_0.setRatings(ratingsSet_0);
			User user0 = userRepository.save(user_0);

			User user_1 = new User();
			user_1.setFirstName("Firstname2");
			user_1.setLastName("LastName2");
			user_1.setEmail("2test@test.de");

			Rating rating_1 = new Rating();
			rating_1.setRatingScore(3.5);
			Rating rating1 = ratingRepository.save(rating_1);
			Set<Rating> ratingSet_1 = new HashSet<>();
			ratingSet_1.add(rating_1);
			user_1.setRatings(ratingSet_1);


			Set<Rating> ratingSet = new HashSet<>();
			ratingSet.add(rating0);
			ratingSet.add(rating1);

			Coupon coupon = new Coupon();
			coupon.setName("50Coupon");
			coupon.setDescription("50 % discount");
			coupon.setCouponCode(456);
			Coupon coupon0 = couponRepository.save(coupon);
			Set<Coupon> couponSet = new HashSet<>();
			couponSet.add(coupon0);

			user0.setFavoriteCoupons(couponSet);
			User user1 = userRepository.save(user_0);

			Product product_0 = new Product();
			product_0.setName("Brot");
			product_0.setDescription("Trokenes Brot");
			product_0.setPrice(2.00);
			Product product0 = productRepository.save(product_0);

			Set<Product> productSet = new HashSet<>();
			productSet.add(product0);

			Message message_0 = new Message();
			message_0.setMessage("Nachricht 1 ");
			message_0.setCreated(new Date());
			messageRepository.save(message_0);

			Set<Message> messages = new HashSet<>();
			messages.add(message_0);

			Vendor vendor_0 = new Vendor();
			vendor_0.setName("Mayersche Gummersbach");
			vendor_0.setEmailAddress("info-gummersbach@mayersche.de");
			vendor_0.setWebsiteURL("https://www.thalia.de/");
			vendor_0.setCategory(VendorCategory.GENERAL);
			Address address0 = new Address();
			address0.setStreet("Kaiserstraße");
			address0.setHouseNr("20");
			address0.setZipCode("51643");
			address0.setPlace("Gummersbach");
			address0.setCountry("Germany");
			vendor_0.setAddress(address0);
			vendor_0.setCoupons(couponSet);
			vendor_0.setColor("#FFFFFF");
			vendor_0.setRatings(ratingSet);
			vendor_0.setProducts(productSet);
			vendor_0.setMessages(messages);
			vendor_0.setLogo("https://upload.wikimedia.org/wikipedia/commons/4/44/Logo_Mayersche_Buchhandlung.png");
			vendor_0.setDetailImages(detailImagesMayerscheGummersbach);
			vendor_0.setEvents(eventSet_0);
			OpeningTime openingTime = new OpeningTime("8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-18:00","Closed");
			vendor_0.setOpeningTime(openingTime);

			Vendor vendor0 = vendorRepository.save(vendor_0);


			Set<Vendor> vendorSet0 = new HashSet<>();
			vendorSet0.add(vendor0);
			user0.setFavoriteVendors(vendorSet0);

			user0 = userRepository.save(user0);


			Set<Vendor> vendorSet = new HashSet<>();
			vendorSet.add(vendor0);
			user0.setFavoriteVendors(vendorSet);
			userRepository.save(user_0);

			Vendor vendor1 = new Vendor();
			vendor1.setName("Forum Gummersbach");
			vendor1.setEmailAddress("info@forum-gummersbach.info");
			vendor1.setColor("#e2a363");
			vendor1.setWebsiteURL("https://www.forum-gummersbach.info");
			vendor1.setLogo("https://www.hbb.de/wp-content/uploads/2020/08/HBB_Gummersbach_header-1024x427.jpeg");
			vendor1.setDetailImages(detailImagesForumGummersbach);
			Address address1 = new Address();
			address1.setStreet("Steinmüllerallee");
			address1.setHouseNr("5");
			address1.setZipCode("51643");
			address1.setPlace("Gummersbach");
			address1.setCountry("Germany");
			vendor1.setAddress(address1);
			vendorRepository.save(vendor1);

			Vendor vendor2 = new Vendor();
			vendor2.setName("Street One Retail GmbH");
			vendor2.setEmailAddress("onlineshop@kundenservice.streetone.de");
			vendor2.setWebsiteURL("https://streetone.de");
			vendor2.setColor("#FD0000");
			vendor2.setLogo("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2015/08/Street-One_170927_Forum_Gummersbach_0022.jpg");
			vendor2.setDetailImages(detailImagesStreetOneRetailGmbH);
			Address address2 = new Address();
			address2.setStreet("Steinmüllerallee");
			address2.setHouseNr("5");
			address2.setZipCode("51643");
			address2.setPlace("Gummersbach");
			address2.setCountry("Germany");
			vendor2.setAddress(address2);
			vendorRepository.save(vendor2);

			Vendor vendor3 = new Vendor();
			vendor3.setName("Alanya Restaurant Gummersbach");
			vendor3.setEmailAddress("alanya-restaurant@web.de");
			vendor3.setColor("#610505");
			vendor3.setWebsiteURL("https://www.facebook.com/alanyarestaurant");
			vendor3.setLogo("https://media-cdn.tripadvisor.com/media/photo-s/11/77/d7/59/das-richtige-restaurant.jpg");
			vendor3.setDetailImages(detailImagesAlanyaRestaurantGummersbach);
			vendor3.setCategory(VendorCategory.RESTAURANT);
			Address address3 = new Address();
			address3.setStreet("Hindenburgstraße");
			address3.setHouseNr("10-12");
			address3.setZipCode("51643");
			address3.setPlace("Gummersbach");
			address3.setCountry("Germany");
			vendor3.setAddress(address3);
			vendorRepository.save(vendor3);

			Vendor vendor4 = new Vendor();
			vendor4.setName("Bergischer Hof");
			vendor4.setEmailAddress("info@ic-verwaltungsgruppe.de");
			vendor4.setWebsiteURL("ic-verwaltungsgruppe.de");
			vendor4.setColor("#A5C715");
			vendor4.setLogo("https://infax.org/hotelrestaurantbergischerhof/wp-content/uploads/sites/157/2020/08/IMG_4312_bergischer_hof_bei_Nacht.jpg");
			vendor4.setDetailImages(detailImagesBergischerHof);
			Address address4 = new Address();
			address4.setStreet("Kaiserstraße");
			address4.setHouseNr("35");
			address4.setZipCode("51643");
			address4.setPlace("Gummersbach");
			address4.setCountry("Germany");
			vendor4.setAddress(address4);
			vendorRepository.save(vendor4);

			Vendor vendor5 = new Vendor();
			vendor5.setName("Engbers");
			vendor5.setEmailAddress("shop@engbers.com");
			vendor5.setWebsiteURL("engbers.com");
			vendor5.setColor("#056118");
			vendor5.setLogo("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Engbers_%28Unternehmen%29_logo.svg/1200px-Engbers_%28Unternehmen%29_logo.svg.png");
			vendor5.setDetailImages(detailImagesEngbers);
			Address address5 = new Address();
			address5.setStreet("Steinmüllerallee");
			address5.setHouseNr("5");
			address5.setZipCode("51643");
			address5.setPlace("Gummersbach");
			address5.setCountry("Germany");
			vendor5.setAddress(address5);
			vendorRepository.save(vendor5);

			Vendor vendor6 = new Vendor();
			vendor6.setName("TAKKO FASHION Gummersbach");
			vendor6.setEmailAddress("support@takko.de");
			vendor6.setLogo("https://static0.tiendeo.de/images/tiendas/18910/catalogos/745590/paginas/mid2/00001.jpg");
			vendor6.setDetailImages(detailImagesTakkoFashionGummersbach);
			Address address6 = new Address();
			address6.setStreet("Kaiserstraße");
			address6.setHouseNr("35");
			address6.setZipCode("51643");
			address6.setPlace("Gummersbach");
			address6.setCountry("Germany");
			vendor6.setAddress(address6);
			vendorRepository.save(vendor6);

			Vendor vendor7 = new Vendor();
			vendor7.setName("CECIL Partner Store Gummersbach");
			vendor7.setEmailAddress("support@takko.de");
			vendor7.setLogo("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2018/10/Cecil_DSC00427.jpg");
			vendor7.setDetailImages(detailImagesCecilPartnerStoreGummersbach);
			Address address7 = new Address();
			address7.setStreet("Steinmüllerallee");
			address7.setHouseNr("25");
			address7.setZipCode("51643");
			address7.setPlace("Gummersbach");
			address7.setCountry("Germany");
			vendor7.setAddress(address7);
			vendorRepository.save(vendor7);

			Vendor vendor8 = new Vendor();
			vendor8.setName("KULT");
			vendor8.setEmailAddress("info@goergens-gruppe.de");
			vendor8.setLogo("https://www.kult-olymp-hades.de/media/image/d7/cc/9e/kult_vintage_logo.png");
			vendor8.setDetailImages(detailImagesKult);
			Address address8 = new Address();
			address8.setStreet("Steinmüllerallee");
			address8.setHouseNr("5");
			address8.setZipCode("51643");
			address8.setPlace("Gummersbach");
			address8.setCountry("Germany");
			vendor8.setAddress(address8);
			vendorRepository.save(vendor8);
		};
	}
}
