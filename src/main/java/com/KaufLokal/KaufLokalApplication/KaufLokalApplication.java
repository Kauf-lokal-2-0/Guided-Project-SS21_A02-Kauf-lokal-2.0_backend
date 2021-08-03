package com.KaufLokal.KaufLokalApplication;


import com.KaufLokal.KaufLokalApplication.domain.embeddable.Address;
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
								  MessageRepository messageRepository,
								  EventRepository eventRepository,
								  PollRepository pollRepository,
								  PollOptionRepository pollOptionRepository,
								  ExperienceRepository experienceRepository
	) {
		return (args) -> {


			User user_10 = new User();
			user_10.setFirstName("Firstname10");
			user_10.setLastName("LastName10");
			user_10.setEmail("test10@test.de");
			user_10.setLevel(14);
			User user10 = userRepository.save(user_10);

			User user_11 = new User();
			user_11.setFirstName("Firstname11");
			user_11.setLastName("LastName11");
			user_11.setEmail("test11@test.de");
			user_11.setLevel(11);
			User user11 = userRepository.save(user_11);

			User user_12 = new User();
			user_12.setFirstName("Firstname12");
			user_12.setLastName("LastName12");
			user_12.setEmail("test12@test.de");
			user_12.setLevel(9);
			User user12 = userRepository.save(user_12);

			User user_13 = new User();
			user_13.setFirstName("Firstname13");
			user_13.setLastName("LastName13");
			user_13.setEmail("test13@test.de");
			user_13.setLevel(91);
			User user13 = userRepository.save(user_13);

			User user_14 = new User();
			user_14.setFirstName("Firstname14");
			user_14.setLastName("LastName14");
			user_14.setEmail("test14@test.de");
			user_14.setLevel(72);
			User user14 = userRepository.save(user_14);

			User user_15 = new User();
			user_15.setFirstName("Firstname15");
			user_15.setLastName("LastName15");
			user_15.setEmail("test15@test.de");
			user_15.setLevel(45);
			User user15 = userRepository.save(user_15);

			User user_16 = new User();
			user_16.setFirstName("Firstname16");
			user_16.setLastName("LastName16");
			user_16.setEmail("test16@test.de");
			user_16.setLevel(36);
			User user16 = userRepository.save(user_16);

			User user_17 = new User();
			user_17.setFirstName("Firstname17");
			user_17.setLastName("LastName17");
			user_17.setEmail("test17@test.de");
			user_17.setLevel(39);
			User user17 = userRepository.save(user_17);

			User user_18 = new User();
			user_18.setFirstName("Firstname18");
			user_18.setLastName("LastName18");
			user_18.setEmail("test18@test.de");
			user_18.setLevel(19);
			User user18 = userRepository.save(user_18);

			User user_19 = new User();
			user_19.setFirstName("Firstname19");
			user_19.setLastName("LastName19");
			user_19.setEmail("test19@test.de");
			user_19.setLevel(159);
			User user19 = userRepository.save(user_19);

			User user_20 = new User();
			user_20.setFirstName("Firstname20");
			user_20.setLastName("LastName20");
			user_20.setEmail("test20@test.de");
			user_20.setLevel(168);
			User user20 = userRepository.save(user_20);

			User user_21 = new User();
			user_21.setFirstName("Firstname20");
			user_21.setLastName("LastName20");
			user_21.setEmail("test2@test.de");
			user_21.setLevel(98);
			User user21 = userRepository.save(user_21);

			User user_22 = new User();
			user_22.setFirstName("Firstname2");
			user_22.setLastName("LastName2");
			user_22.setEmail("test2@test.de");
			user_22.setLevel(98);
			User user22 = userRepository.save(user_22);

			User user_23 = new User();
			user_23.setFirstName("Firstname");
			user_23.setLastName("LastName");
			user_23.setEmail("test@test.de");
			user_23.setLevel(18);
			User user23 = userRepository.save(user_23);

			User user_24 = new User();
			user_24.setFirstName("Firstname");
			user_24.setLastName("LastName");
			user_24.setEmail("test@test.de");
			user_24.setLevel(128);
			User user24 = userRepository.save(user_24);

			User user_25 = new User();
			user_25.setFirstName("Firstname");
			user_25.setLastName("LastName");
			user_25.setEmail("test@test.de");
			user_25.setLevel(128);
			User user25 = userRepository.save(user_25);

			User user_26 = new User();
			user_26.setFirstName("Firstname");
			user_26.setLastName("LastName");
			user_26.setEmail("test@test.de");
			user_26.setLevel(128);
			User user26 = userRepository.save(user_26);

			User user_27 = new User();
			user_27.setFirstName("Firstname");
			user_27.setLastName("LastName");
			user_27.setEmail("test@test.de");
			user_27.setLevel(12);
			User user27 = userRepository.save(user_27);

			User user_28 = new User();
			user_28.setFirstName("Firstname");
			user_28.setLastName("LastName");
			user_28.setEmail("test@test.de");
			user_28.setLevel(124);
			User user28 = userRepository.save(user_28);

			User user_29 = new User();
			user_29.setFirstName("Firstname");
			user_29.setLastName("LastName");
			user_29.setEmail("test@test.de");
			user_29.setLevel(134);
			User user29 = userRepository.save(user_29);

			User user_30 = new User();
			user_30.setFirstName("Firstname");
			user_30.setLastName("LastName");
			user_30.setEmail("test@test.de");
			user_30.setLevel(135);
			User user30 = userRepository.save(user_30);



			Set<User> userSet_poll1 = new HashSet<>();
			userSet_poll1.add(user28);
			userSet_poll1.add(user27);
			userSet_poll1.add(user24);
			userSet_poll1.add(user15);
			userSet_poll1.add(user23);
			userSet_poll1.add(user18);
			userSet_poll1.add(user16);
			userSet_poll1.add(user10);
			userSet_poll1.add(user19);
			userSet_poll1.add(user17);

			Set<User> userSet_poll2 = new HashSet<>();
			userSet_poll2.add(user29);
			userSet_poll2.add(user_30);
			userSet_poll2.add(user22);

			Set<User> userSet_poll3 = new HashSet<>();
			userSet_poll3.add(user26);
			userSet_poll3.add(user25);
			userSet_poll3.add(user12);
			userSet_poll3.add(user13);
			userSet_poll3.add(user21);
			userSet_poll3.add(user20);
			userSet_poll3.add(user11);
			userSet_poll3.add(user14);



			User user_0 = new User();
			user_0.setFirstName("Falah");
			user_0.setLastName("LastName");
			user_0.setEmail("test@test.de");

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

			Message message_0 = new Message();
			message_0.setContentMessage("Nachricht 1 ");
			message_0.setTitle("Nachricht Title");
			message_0.setImageURL("https://www.message-networks.com/wp-content/uploads/2020/01/android_messages_rcs.png");

			Message message0 = messageRepository.save(message_0);

			Set<Message> messages = new HashSet<>();
			messages.add(message0);

			Event event_0 = new Event();
			event_0.setEventTypes(EventTypes.MESSAGE);
			event_0.setRefId(message0.getId());
			Event event0 = eventRepository.save(event_0);

			Set<Event> eventSet_0 = new HashSet<>();
			eventSet_0.add(event0);

			Vendor vendor_0 = new Vendor();
			vendor_0.setName("Mayersche Gummersbach");
			vendor_0.setEmail("info-gummersbach@mayersche.de");
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
			vendor_0.setMessages(messages);
			vendor_0.setLogo("https://upload.wikimedia.org/wikipedia/commons/4/44/Logo_Mayersche_Buchhandlung.png");
			vendor_0.setDetailImages(detailImagesMayerscheGummersbach);
			OpeningTime openingTime = new OpeningTime("8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-18:00","Closed");
			vendor_0.setOpeningTime(openingTime);
			Vendor vendor0 = vendorRepository.save(vendor_0);

			// USER EXP


			Experience experience_0 = new Experience();
			experience_0.setUser(user0);
			experience_0.setVendor(vendor0);
			experience_0.setDescription("Einkauf für 300 Euro");
			experience_0.setUserExperience(150);
			experienceRepository.save(experience_0);





			//message0.setVendor(vendor0);
			messageRepository.save(message0);

			coupon0 = couponRepository.save(coupon0);

			event_0.setVendorId(vendor0.getId());
			event_0 = eventRepository.save(event_0);

			Event eventCoupon_0 = new Event();
			eventCoupon_0.setEventTypes(EventTypes.COUPON);
			eventCoupon_0.setRefId(coupon0.getId());
			eventCoupon_0.setVendorId(vendor0.getId());
			Event eventCoupon0 = eventRepository.save(eventCoupon_0);
			eventSet_0.add(eventCoupon0);

			Event eventUpdate_0 = new Event();
			eventUpdate_0.setEventTypes(EventTypes.UPDATE);
			eventUpdate_0.setVendorId(vendor0.getId());
			eventUpdate_0.setRefId(message0.getId());
			Event eventUpdate0 = eventRepository.save(eventUpdate_0);
			eventSet_0.add(eventUpdate0);

			///Voting
			Set<PollOption> pollOptions = new HashSet<>();

			PollOption pollOption0 = new PollOption();
			pollOption0.setTitle("Glücksrad");




			pollOption0.setUsers(userSet_poll1);
			PollOption pollOption_0 = pollOptionRepository.save(pollOption0);
			pollOptions.add(pollOption_0);

			PollOption pollOption1 = new PollOption();
			pollOption1.setTitle("Lose ziehen");
			pollOption1.setUsers(userSet_poll2);
			PollOption pollOption_1 = pollOptionRepository.save(pollOption1);
			pollOptions.add(pollOption_1);

			PollOption pollOption2 = new PollOption();
			pollOption2.setTitle("Quiz");
			pollOption2.setUsers(userSet_poll3);
			PollOption pollOption_2 = pollOptionRepository.save(pollOption2);
			pollOptions.add(pollOption_2);

			Poll poll0 = new Poll();
			poll0.setTitle("Welche der Aktionen finden Sie am besten ?");
			poll0.setVendor(vendor0);
			Poll poll_0 = pollRepository.save(poll0);
			poll_0.setPollOptions(pollOptions);
			poll_0 = pollRepository.save(poll_0);
			poll_0.setImageURL("https://st2.depositphotos.com/1005979/8844/i/950/depositphotos_88446424-stock-photo-poll-survey-results-voting.jpg");

			Event eventVoting_0 = new Event();
			eventVoting_0.setEventTypes(EventTypes.POLL);
			eventVoting_0.setRefId(poll_0.getId());
			eventVoting_0.setVendorId(vendor0.getId());
			Event eventVoting0 = eventRepository.save(eventVoting_0);
			eventSet_0.add(eventVoting0);

			vendor0.setEvents(eventSet_0);


			// Vendor favorisieren
			Set<Vendor> vendorSet0 = new HashSet<>();
			vendorSet0.add(vendor0);
			user0.setFavoriteVendors(vendorSet0);
			user0 = userRepository.save(user0);
			Set<Vendor> vendorSet = new HashSet<>();
			vendorSet.add(vendor0);
			user0.setFavoriteVendors(vendorSet);
			userRepository.save(user_0);




			/// Beispiel 1

			Vendor vendor1 = new Vendor();
			vendor1.setName("Forum Gummersbach");
			vendor1.setCategory(VendorCategory.GENERAL);
			vendor1.setEmail("info@forum-gummersbach.info");
			vendor1.setColor("#e2a363");
			vendor1.setWebsiteURL("https://www.forum-gummersbach.info");
			vendor1.setLogo("https://www.hbb.de/wp-content/uploads/2020/08/HBB_Gummersbach_header-1024x427.jpeg");
			vendor1.setDetailImages(detailImagesForumGummersbach);
			vendor1.setOpeningTime(openingTime);
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
			vendor2.setEmail("onlineshop@kundenservice.streetone.de");
			vendor2.setWebsiteURL("https://streetone.de");
			vendor2.setColor("#FD0000");
			vendor2.setCategory(VendorCategory.CLOTHES);
			vendor2.setLogo("https://www.forum-gummersbach.info/wp-content/uploads/sites/2/2015/08/Street-One_170927_Forum_Gummersbach_0022.jpg");
			vendor2.setDetailImages(detailImagesStreetOneRetailGmbH);
			vendor2.setOpeningTime(openingTime);
			Address address2 = new Address();
			address2.setStreet("Steinmüllerallee");
			address2.setHouseNr("5");
			address2.setZipCode("51643");
			address2.setPlace("Gummersbach");
			address2.setCountry("Germany");
			vendor2.setAddress(address2);
			vendorRepository.save(vendor2);


		};
	}
}
