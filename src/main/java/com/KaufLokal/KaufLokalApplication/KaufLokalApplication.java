package com.KaufLokal.KaufLokalApplication;


import com.KaufLokal.KaufLokalApplication.domain.model.*;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.MerchantCategory;
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
	public CommandLineRunner demo(MerchantRepository merchantRepository ,
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

			User user1 = userRepository.save(user_0);

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

			Merchant merchant_0 = new Merchant();
			merchant_0.setName("Mayersche Gummersbach");
			merchant_0.setCompany("Mayersche Gummersbach");
			merchant_0.setEmailAddress("info-gummersbach@mayersche.de");
			merchant_0.setWebsiteURL("https://www.thalia.de/");
			merchant_0.setCategory(MerchantCategory.GENERAL);
			Address address0 = new Address();
			address0.setStreet("Kaiserstraße");
			address0.setHouseNr("20");
			address0.setZipCode("51643");
			address0.setPlace("Gummersbach");
			address0.setCountry("Germany");
			merchant_0.setAddress(address0);
			merchant_0.setCoupons(couponSet);
			merchant_0.setRatings(ratingSet);
			merchant_0.setProducts(productSet);
			merchant_0.setMessages(messages);
			merchant_0.setProfilePicture("https://upload.wikimedia.org/wikipedia/commons/4/44/Logo_Mayersche_Buchhandlung.png");
			merchant_0.setEvents(eventSet_0);
			OpeningTime openingTime = new OpeningTime("8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-18:00","Closed");
			merchant_0.setOpeningTime(openingTime);

			Merchant merchant0 = merchantRepository.save(merchant_0);


			Set<Merchant> merchantSet0 = new HashSet<>();
			merchantSet0.add(merchant0);
			user0.setFavoriteMerchants(merchantSet0);

			user0 = userRepository.save(user0);


			Set<Merchant> merchantSet = new HashSet<>();
			merchantSet.add(merchant0);
			user0.setFavoriteMerchants(merchantSet);
			userRepository.save(user_0);

			Merchant merchant1 = new Merchant();
			merchant1.setName("Forum Gummersbach");
			merchant1.setCompany("Forum Gummersbach");
			merchant1.setEmailAddress("info@forum-gummersbach.info");
			merchant1.setWebsiteURL("https://www.forum-gummersbach.info");
			merchant1.setProfilePicture("https://www.hbb.de/wp-content/uploads/2020/08/HBB_Gummersbach_header-1024x427.jpeg");
			Address address1 = new Address();
			address1.setStreet("Steinmüllerallee");
			address1.setHouseNr("5");
			address1.setZipCode("51643");
			address1.setPlace("Gummersbach");
			address1.setCountry("Germany");
			merchant1.setAddress(address1);
			merchantRepository.save(merchant1);

			Merchant merchant2 = new Merchant();
			merchant2.setName("Street One Retail GmbH");
			merchant2.setCompany("Street One Retail GmbH");
			merchant2.setEmailAddress("onlineshop@kundenservice.streetone.de");
			merchant2.setWebsiteURL("https://streetone.de");
			merchant2.setProfilePicture("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2015/08/Street-One_170927_Forum_Gummersbach_0022.jpg");
			Address address2 = new Address();
			address2.setStreet("Steinmüllerallee");
			address2.setHouseNr("5");
			address2.setZipCode("51643");
			address2.setPlace("Gummersbach");
			address2.setCountry("Germany");
			merchant2.setAddress(address2);
			merchantRepository.save(merchant2);

			Merchant merchant3 = new Merchant();
			merchant3.setName("Alanya Restaurant Gummersbach");
			merchant3.setCompany("Alanya Restaurant Gummersbach");
			merchant3.setEmailAddress("alanya-restaurant@web.de");
			merchant3.setWebsiteURL("https://www.facebook.com/alanyarestaurant");
			merchant3.setProfilePicture("https://media-cdn.tripadvisor.com/media/photo-s/11/77/d7/59/das-richtige-restaurant.jpg");
			merchant3.setCategory(MerchantCategory.RESTAURANT);
			Address address3 = new Address();
			address3.setStreet("Hindenburgstraße");
			address3.setHouseNr("10-12");
			address3.setZipCode("51643");
			address3.setPlace("Gummersbach");
			address3.setCountry("Germany");
			merchant3.setAddress(address3);
			merchantRepository.save(merchant3);

			Merchant merchant4 = new Merchant();
			merchant4.setName("Bergischer Hof");
			merchant4.setCompany("Bergischer Hof");
			merchant4.setEmailAddress("info@ic-verwaltungsgruppe.de");
			merchant4.setWebsiteURL("ic-verwaltungsgruppe.de");
			merchant4.setProfilePicture("https://infax.org/hotelrestaurantbergischerhof/wp-content/uploads/sites/157/2020/08/IMG_4312_bergischer_hof_bei_Nacht.jpg");
			Address address4 = new Address();
			address4.setStreet("Kaiserstraße");
			address4.setHouseNr("35");
			address4.setZipCode("51643");
			address4.setPlace("Gummersbach");
			address4.setCountry("Germany");
			merchant4.setAddress(address4);
			merchantRepository.save(merchant4);

			Merchant merchant5 = new Merchant();
			merchant5.setName("Engbers");
			merchant5.setCompany("Engbers");
			merchant5.setEmailAddress("shop@engbers.com");
			merchant5.setWebsiteURL("engbers.com");
			merchant5.setProfilePicture("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Engbers_%28Unternehmen%29_logo.svg/1200px-Engbers_%28Unternehmen%29_logo.svg.png");
			Address address5 = new Address();
			address5.setStreet("Steinmüllerallee");
			address5.setHouseNr("5");
			address5.setZipCode("51643");
			address5.setPlace("Gummersbach");
			address5.setCountry("Germany");
			merchant5.setAddress(address5);
			merchantRepository.save(merchant5);

			Merchant merchant6 = new Merchant();
			merchant6.setName("Engbers");
			merchant6.setCompany("Engbers");
			merchant6.setEmailAddress("shop@engbers.com");
			merchant6.setProfilePicture("https://www.forum-hanau.net/wp-content/uploads/sites/3/2015/08/engbers_170630_Forum_Hanau_0159.jpg");
			Address address6 = new Address();
			address6.setStreet("Steinmüllerallee");
			address6.setHouseNr("5");
			address6.setZipCode("51643");
			address6.setPlace("Gummersbach");
			address6.setCountry("Germany");
			merchant6.setAddress(address6);
			merchantRepository.save(merchant6);

			Merchant merchant7 = new Merchant();
			merchant7.setName("TAKKO FASHION Gummersbach");
			merchant7.setCompany("TAKKO FASHION Gummersbach");
			merchant7.setEmailAddress("support@takko.de");
			merchant7.setProfilePicture("https://static0.tiendeo.de/images/tiendas/18910/catalogos/745590/paginas/mid2/00001.jpg");
			Address address7 = new Address();
			address7.setStreet("Kaiserstraße");
			address7.setHouseNr("35");
			address7.setZipCode("51643");
			address7.setPlace("Gummersbach");
			address7.setCountry("Germany");
			merchant7.setAddress(address7);
			merchantRepository.save(merchant7);

			Merchant merchant8 = new Merchant();
			merchant8.setName("CECIL Partner Store Gummersbach");
			merchant8.setCompany("CECIL Partner Store Gummersbach");
			merchant8.setEmailAddress("support@takko.de");
			merchant8.setProfilePicture("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2018/10/Cecil_DSC00427.jpg");
			Address address8 = new Address();
			address8.setStreet("Steinmüllerallee");
			address8.setHouseNr("25");
			address8.setZipCode("51643");
			address8.setPlace("Gummersbach");
			address8.setCountry("Germany");
			merchant8.setAddress(address8);
			merchantRepository.save(merchant8);

			Merchant merchant9 = new Merchant();
			merchant9.setName("KULT");
			merchant9.setCompany("KULT");
			merchant9.setEmailAddress("info@goergens-gruppe.de");
			merchant8.setProfilePicture("https://www.kult-olymp-hades.de/media/image/d7/cc/9e/kult_vintage_logo.png");
			Address address9 = new Address();
			address9.setStreet("Steinmüllerallee");
			address9.setHouseNr("5");
			address9.setZipCode("51643");
			address9.setPlace("Gummersbach");
			address9.setCountry("Germany");
			merchant9.setAddress(address9);
			merchantRepository.save(merchant9);


		};
	}




}
