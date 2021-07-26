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
								  MessageRepository messageRepository,
								  EventRepository eventRepository,
								  VotingRepository votingRepository,
								  VotingOptionRepository votingOptionRepository
	) {
		return (args) -> {

			User user_0 = new User();
			user_0.setFirstName("Firstname");
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
			message_0.setMessage("Nachricht 1 ");
			message_0.setCreated(new Date());
			Message message0 = messageRepository.save(message_0);

			Set<Message> messages = new HashSet<>();
			messages.add(message0);

			Event event_0 = new Event();
			event_0.setCreated(new Date());
			event_0.setEventTypes(EventTypes.MESSAGE);
			event_0.setCreated(new Date());
			event_0.setRefId(message0.getId());
			Event event0 = eventRepository.save(event_0);

			Set<Event> eventSet_0 = new HashSet<>();
			eventSet_0.add(event0);

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
			vendor_0.setMessages(messages);
			vendor_0.setLogo("https://upload.wikimedia.org/wikipedia/commons/4/44/Logo_Mayersche_Buchhandlung.png");
			vendor_0.setDetailImages(detailImagesMayerscheGummersbach);
			OpeningTime openingTime = new OpeningTime("8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-20:00","8:00-18:00","Closed");
			vendor_0.setOpeningTime(openingTime);
			Vendor vendor0 = vendorRepository.save(vendor_0);
			coupon0 = couponRepository.save(coupon0);

			event_0.setVendorId(vendor0.getId());
			event_0 = eventRepository.save(event_0);

			Event eventCoupon_0 = new Event();
			eventCoupon_0.setCreated(new Date());
			eventCoupon_0.setEventTypes(EventTypes.COUPON);
			eventCoupon_0.setCreated(new Date());
			eventCoupon_0.setRefId(coupon0.getId());
			eventCoupon_0.setVendorId(vendor0.getId());
			Event eventCoupon0 = eventRepository.save(eventCoupon_0);
			eventSet_0.add(eventCoupon0);

			Event eventUpdate_0 = new Event();
			eventUpdate_0.setCreated(new Date());
			eventUpdate_0.setEventTypes(EventTypes.UPDATE);
			eventUpdate_0.setCreated(new Date());
			eventUpdate_0.setVendorId(vendor0.getId());
			eventUpdate_0.setRefId(message0.getId());
			Event eventUpdate0 = eventRepository.save(eventUpdate_0);
			eventSet_0.add(eventUpdate0);

			///Voting
			Set<VotingOption> votingOptions = new HashSet<>();

			VotingOption votingOption0 = new VotingOption();
			votingOption0.setTitle("Glücksrad");
			Set<User> userSet = new HashSet<>();
			userSet.add(user0);
			votingOption0.setUsers(userSet);
			VotingOption votingOption_0 = votingOptionRepository.save(votingOption0);
			votingOptions.add(votingOption_0);

			VotingOption votingOption1 = new VotingOption();
			votingOption1.setTitle("Lose ziehen");
			VotingOption votingOption_1 = votingOptionRepository.save(votingOption1);
			votingOptions.add(votingOption_1);

			VotingOption votingOption2 = new VotingOption();
			votingOption2.setTitle("Quiz");
			VotingOption votingOption_2 = votingOptionRepository.save(votingOption2);
			votingOptions.add(votingOption_2);

			Voting voting0 = new Voting();
			voting0.setTitle("Welche der Aktionen finden Sie am besten ?");

			Voting voting_0 = votingRepository.save(voting0);
			voting_0.setVotingOptions(votingOptions);
			voting_0 = votingRepository.save(voting_0);

			Event eventVoting_0 = new Event();
			eventVoting_0.setCreated(new Date());
			eventVoting_0.setEventTypes(EventTypes.POLL);
			eventVoting_0.setCreated(new Date());
			eventVoting_0.setRefId(voting_0.getId());
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
			vendor1.setEmailAddress("info@forum-gummersbach.info");
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
			vendor2.setEmailAddress("onlineshop@kundenservice.streetone.de");
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
