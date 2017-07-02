import cn.itcast.commons.CommonUtils;
import com.indiv.dao.CustomerDao;
import com.indiv.entity.Customer;
import org.junit.jupiter.api.Test;

/**
 * Created by wangsongyan on 2017/7/2.
 * email: wangsongyan921@163.com
 */
public class TestAdd {

    @Test
    public void add(){
        CustomerDao customerDao = new CustomerDao();
        for (int i = 0; i < 300; i++) {
            Customer customer = new Customer();
            customer.setCid(CommonUtils.uuid());
            customer.setCname("customer_"+i);
            customer.setBirthday("2015-07-19");
            if (i% 2==0){
                customer.setGender("男");
            }else {
                customer.setGender("女");
            }

            customer.setCellphone("139"+i);
            customer.setEmail("customer_"+i+"@163.com");
            customer.setDescription("测试");
            customerDao.add(customer);
        }
    }
}
