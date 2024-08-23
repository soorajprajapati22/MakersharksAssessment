package com.MakerSharks.MakerSharks.Service;

import com.MakerSharks.MakerSharks.Entity.Supplier;

import java.util.List;

public interface supplierService {

    Supplier createSupplier(Supplier supplier);

    List<Supplier> filterSuppliers(String location, String nature_of_business, String manufacturing_processes);
}
