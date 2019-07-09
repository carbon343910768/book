package edu.bjtu.xxq.service;

import edu.bjtu.xxq.model.Supplier;
import edu.bjtu.xxq.model.Supply;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SupplyService {

    private final Map<String, Supplier> COMPANY_SUPPLIER = new HashMap<>();
    private final Map<String, Supplier> REG_NO_SUPPLIER = new HashMap<>();
    private final Map<Integer, Supply> ID_SUPPLY = new HashMap<>();
    private final SortedMap<LocalDate, Supply> DATE_SUPPLY = new TreeMap<>();

    {
        String[][] suppliers = {
                {"人民音乐出版社有限公司", "100000000010972", "010-58110625", "rmyy@rymusic.com.cn"},
                {"清华大学出版社有限公司", "110108006753366", "62783933", "alexchenzhw@163.com"},
                {"北京文鑫双赢文化传播有限公司", "110109012135158", "18600900871", "486139461@qq.com"},
                {"武汉大学出版社有限公司", "420100000046040", "027-87215595", "cbs@whu.edu.cn"},
                {"浙江大学出版社有限公司", "330100000094526", "88273066", "zupress@zju.edu.cn"},
                {"延边大学出版社有限公司", "222400000018570", "0433-2732438", "ydcbs@vip.163.com"},
                {"青岛出版社有限公司", "370200020002362", "68068602", "chenxf@citymedia.cn"},
                {"天津大学出版社有限公司", "120104000040796", "022-27405110", "tjdxcbsyxzrgs@163.com"},
                {"河南大学出版社有限公司", "410000000021211", "0371-22861857", "18437816420@163.com"}
        };
        for (String[] supplier : suppliers) {
            addSupplier(new Supplier()
                    .setCompany(supplier[0])
                    .setRegisterNo(supplier[1])
                    .setPhone(supplier[2])
                    .setEmail(supplier[3]));
        }
    }

    public void addSupplier(Supplier supplier) {
        COMPANY_SUPPLIER.put(supplier.getCompany(), supplier);
        REG_NO_SUPPLIER.put(supplier.getRegisterNo(), supplier);
    }

    public Supplier getSupplierByCompany(String company) {
        return COMPANY_SUPPLIER.get(company);
    }

    public Supplier getSupplierByNo(String registerNo) {
        return REG_NO_SUPPLIER.get(registerNo);
    }

    public Collection<Supplier> getAllSuppliers() {
        return COMPANY_SUPPLIER.values();
    }

    private int SUPPLY_COUNT = 0;

    public void addSupply(Supply supply) {
        SUPPLY_COUNT++;
        supply.setId(SUPPLY_COUNT).setDate(LocalDate.now().toString());
        ID_SUPPLY.put(SUPPLY_COUNT, supply);
        DATE_SUPPLY.put(LocalDate.parse(supply.getDate()), supply);
    }

    public Supply getSupplyById(int id) {
        return ID_SUPPLY.get(id);
    }

    public Supply getSupplyByDate(String date) {
        return DATE_SUPPLY.get(LocalDate.parse(date));
    }

    public Collection<Supply> getSupplyBetweenDate(String from, String to) {
        return DATE_SUPPLY.subMap(LocalDate.parse(from), LocalDate.parse(to)).values();
    }

    public Collection<Supply> getAllSupplies() {
        return ID_SUPPLY.values();
    }
}
