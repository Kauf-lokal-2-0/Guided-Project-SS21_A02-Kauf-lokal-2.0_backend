package com.KaufLokal.KaufLokalApplication;


import com.KaufLokal.KaufLokalApplication.domain.model.Address;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import com.KaufLokal.KaufLokalApplication.domain.model.Merchant;
import com.KaufLokal.KaufLokalApplication.domain.model.Offer;
import com.KaufLokal.KaufLokalApplication.domain.repository.CouponRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.MerchantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class KaufLokalApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaufLokalApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MerchantRepository merchantRepository , CouponRepository couponRepository) {
		return (args) -> {

			Coupon coupon = new Coupon();
			coupon.setName("50Coupon");
			coupon.setDescription("50 % discount");
			coupon.setGeneratedCouponCode(456);
			Coupon coupon0 = couponRepository.save(coupon);
			Set<Coupon> couponSet = new HashSet<>();
			couponSet.add(coupon0);


			Merchant merchant0 = new Merchant();
			merchant0.setName("Mayersche Gummersbach");
			merchant0.setCompany("Mayersche Gummersbach");
			merchant0.setEmailAddress("info-gummersbach@mayersche.de");
			Address address0 = new Address();
			address0.setStreet("Kaiserstraße");
			address0.setHouseNr("20");
			address0.setZipCode("51643");
			address0.setPlace("Gummersbach");
			address0.setCountry("Germany");
			merchant0.setAddress(address0);
			merchant0.setCoupons(couponSet);
			merchantRepository.save(merchant0);


			Merchant merchant1 = new Merchant();
			merchant1.setName("Forum Gummersbach");
			merchant1.setCompany("Forum Gummersbach");
			merchant1.setEmailAddress("info@forum-gummersbach.info");
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
			merchant5.setEmailAddress("shop@engbers.com  ");
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
