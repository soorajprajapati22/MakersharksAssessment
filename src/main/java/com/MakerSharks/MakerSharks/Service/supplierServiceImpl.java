package com.MakerSharks.MakerSharks.Service;

import com.MakerSharks.MakerSharks.Entity.Supplier;
import com.MakerSharks.MakerSharks.Repository.supplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class supplierServiceImpl implements supplierService {

    @Autowired
    private supplierRepository supplierRepo;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return this.supplierRepo.save(supplier);
    }

    @Override
    public List<Supplier> filterSuppliers(String location, String natureOfBusiness, String manufacturingProcesses) {
        return this.supplierRepo.findByLocationAndNatureOfBusinessAndManufacturingProcesses(
                location, natureOfBusiness, manufacturingProcesses);
    }
}
