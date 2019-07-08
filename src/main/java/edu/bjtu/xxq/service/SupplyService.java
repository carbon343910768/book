package edu.bjtu.xxq.service;

import edu.bjtu.xxq.model.Supplier;
import edu.bjtu.xxq.model.Supply;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SupplyService {

    private static final Map<String, Supplier> COMPANY_SUPPLIER = new HashMap<>();
    private static final Map<String, Supplier> REG_NO_SUPPLIER = new HashMap<>();
    private static final Map<Integer, Supply> ID_SUPPLY = new HashMap<>();

    public void addSupplier(Supplier supplier) {

    }

}
