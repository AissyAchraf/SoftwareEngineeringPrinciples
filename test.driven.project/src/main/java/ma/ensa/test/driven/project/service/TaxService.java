package ma.ensa.test.driven.project.service;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    public Double calculateTax(double income) {
        if(income >= 0 && income <= 100000) {
            if(income < 10000) {
                return 0D;
            } else {
                return 20D;
            }
        } else {
            return null;
        }
    }

    public Double calculateReduction(int children) {
        if(0 <= children && children <= 10) {
            if(children < 2) {
                return null;
            } else {
                return 15D;
            }
        } else {
            return null;
        }
    }
}
