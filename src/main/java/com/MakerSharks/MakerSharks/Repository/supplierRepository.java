package com.MakerSharks.MakerSharks.Repository;

import com.MakerSharks.MakerSharks.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface supplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.nature_of_business = :natureOfBusiness AND s.manufacturing_processes = :manufacturingProcesses")
    List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcesses(
            String location, String natureOfBusiness, String manufacturingProcesses);

}
