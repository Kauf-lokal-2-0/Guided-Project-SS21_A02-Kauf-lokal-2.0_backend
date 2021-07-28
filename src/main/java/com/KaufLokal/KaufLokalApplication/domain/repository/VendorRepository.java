package com.KaufLokal.KaufLokalApplication.domain.repository;

import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import com.KaufLokal.KaufLokalApplication.domain.model.Message;
import com.KaufLokal.KaufLokalApplication.domain.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {

    Vendor findVendorsByMessages(Message message);

}
