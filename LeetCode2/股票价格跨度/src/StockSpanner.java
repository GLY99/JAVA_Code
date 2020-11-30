//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
//今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
//例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
import java.util.*;
public class StockSpanner {
    public Stack<Integer> price;
    public Stack<Integer> weight;
    public StockSpanner() {
        this.price = new Stack<>();
        this.weight = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!this.price.isEmpty() && this.price.peek() <= price){
            this.price.pop();
            w += this.weight.pop();
        }
        this.price.push(price);
        this.weight.push(w);
        return w;
    }
}
