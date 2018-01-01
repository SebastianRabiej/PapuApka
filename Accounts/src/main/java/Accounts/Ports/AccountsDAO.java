package Accounts.Ports;

import Accounts.Domain.Account;
import Accounts.Domain.ValueObjects.AccountId;

import java.util.List;

public interface AccountsDAO {

    public Account findById(AccountId id);

    public List<Account> findByIds(List<AccountId> id);

}
