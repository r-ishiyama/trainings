package models;

import models.find.Receipt;

import com.google.inject.Inject;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;


public class UserForm {
  @Inject
  public FormFactory formFactory;
  
  public Form<Receipt> f;
  public Receipt receipt;

  public UserForm(Http.Request request){
    this.f = formFactory.form(Receipt.class).bindFromRequest(request);
    this.receipt = f.get();
    System.out.println(receipt.input);
  }

}
