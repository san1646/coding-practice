package utils.leet;

import java.util.*;

/** https://leetcode.com/articles/shopping-offers/ */
public class ShoppingOffers {
  String itemNamel;
  String discount;
  String itemPrice;
  Set<String> offers;
  int qty;

  /**
   * Input: [2,5], [[3,0,5],[1,2,10]], [3,2] Output: 14 Explanation: There are two kinds of items, A
   * and B. Their prices are $2 and $5 respectively. In special offer 1, you can pay $5 for 3A and
   * 0B In special offer 2, you can pay $10 for 1A and 2B. You need to buy 3A and 2B, so you may pay
   * $10 for 1A and 2B (special offer #2), and $4 for 2A.
   *
   * @param price
   * @param special
   * @param needs
   * @return
   */
  public int optimalPriceForItems(
      List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
   /* int rawPrice = 0;
    for (int k = 0; k < price.size(); k++) {
      rawPrice += price.get(k) * needs.get(k); // assuming size is same
    }*/

      Map < List < Integer > , Integer > map = new HashMap();

    return shopping(price, special, needs, map);
  }

  private int shopping(List<Integer> price,
                       List<List<Integer>> special,
                       List<Integer> needs,
                       Map<List<Integer>, Integer> map) {

      if(map.containsKey(needs)) return map.get(needs);

      int j=0, res=dot(needs, price);

      for (int i = 0; i < special.size(); i++) {

          List<Integer> clone = new ArrayList<>(needs);

          for (int n :needs ) {
              int diff = clone.get(j)-special.get(i).get(j);
              if(diff<0) break;
              clone.set(j, diff);
          }
          if(j==needs.size()){
              res = Math.min(res, special.get(i).get(j)+
                      shopping(price, special,  clone, map));
          }

      }
      map.put(needs, res);
      return res;
  }

    private int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }


}
