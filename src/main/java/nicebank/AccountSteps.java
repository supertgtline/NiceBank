package nicebank;

import org.testng.Assert;

public class AccountSteps {
    KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(
            @Transform(MoneyConverter.class) Money amount)
            throws Throwable {
        helper.getMyAccount().credit(amount);

        Assert.assertEquals("Incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(
            @Transform(MoneyConverter.class) Money amount)
            throws Throwable {

        Assert.assertEquals("Incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }
}
