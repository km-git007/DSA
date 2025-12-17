class Coupon{
    String code, business;
    Coupon(String code, String business){
        this.code = code;
        this.business = business; 
    }
}

class Solution {
    private boolean isValidCoupon(String code, String businessLine, boolean isActive){
        if(!isActive || code == null || code.isEmpty() || !map.containsKey(businessLine))
        return false;

        for (char c : code.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    private Map<String, Integer> map;
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        // build map
        buildPriorityMap();

        List<Coupon> couponList = new ArrayList<>();
        for(int i = 0; i < code.length; i++){
            if(isValidCoupon(code[i], businessLine[i], isActive[i])){
                couponList.add(new Coupon(code[i], businessLine[i]));
            }
        }

        couponList.sort((a, b) -> {
            if(map.get(a.business) - map.get(b.business) == 0){
                return a.code.compareTo(b.code);
            }
            return map.get(a.business) - map.get(b.business);
        });

        List<String> validCoupons = new ArrayList<>();
        for(Coupon coupon : couponList){
            validCoupons.add(coupon.code);
        }
        return validCoupons;
    }

    private void buildPriorityMap(){
        // Create a map that defines the order
        map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);
    }
}

