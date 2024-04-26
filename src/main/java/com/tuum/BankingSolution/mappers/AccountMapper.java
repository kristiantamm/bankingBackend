package com.tuum.BankingSolution.mappers;
import com.tuum.BankingSolution.objects.Account;
import org.apache.ibatis.annotations.*;
@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM account WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "balances", column= "balances")
    })
    Account findAccountById(Long id);

    @Insert("INSERT INTO account (customer_id) VALUES (#{customerId})")
    void insertAccount(Account account);

    @Update("UPDATE account SET customer_id = #{customerId} WHERE id = #{id}")
    void updateAccount(Account account);

    @Delete("DELETE FROM account WHERE id = #{id}")
    void deleteAccount(Long id);
}
