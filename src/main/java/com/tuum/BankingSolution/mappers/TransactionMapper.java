package com.tuum.BankingSolution.mappers;

import com.tuum.BankingSolution.objects.Transaction;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TransactionMapper {

    @Select("SELECT * FROM transaction WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "accountId", column = "account_id"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "currency", column = "currency"),
            @Result(property = "direction", column = "direction"),
            @Result(property = "description", column = "description"),
            @Result(property = "balanceAfterTransaction", column = "balance_after_transaction"),
    })
    Transaction findTransactionById(Long id);

    @Insert("INSERT INTO transaction (account_id, amount, currency, direction, description, balance_after_transaction) VALUES (#{accountId}, #{amount}, #{currency}, #{direction}, #{description}, #{balanceAfterTransaction})")
    void insertTransaction(Transaction transaction);

    @Update("UPDATE transaction SET account_id = #{accountId}, amount = #{amount}, currency = #{currency}, direction = #{direction}, description = #{description}, balance_after_transaction = #{balanceAfterTransaction} WHERE id = #{id}")
    void updateTransaction(Transaction transaction);

    @Delete("DELETE FROM transaction WHERE id = #{id}")
    void deleteTransaction(Long id);
}
