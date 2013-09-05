package swp;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("swp.GuessValidator")
public class GuessValidator implements javax.faces.validator.Validator {

	@Override
	public void validate(FacesContext fc, UIComponent ui, Object o)
			throws ValidatorException {
		
				 int guessValue = Integer.parseInt(o.toString());
				 
				 
				 if (o instanceof Integer) { 
					 if (1 > guessValue || guessValue > 100 )	{
						 FacesMessage msg = new FacesMessage(guessValue + " is invalid! Only numbers between 1 - 100 is accepted ");
						msg.setSeverity(FacesMessage.SEVERITY_ERROR);
						 throw new ValidatorException(msg);
					 }
				} else {
					 FacesMessage msg = new FacesMessage(o.toString() + " is invalid! Only numbers between 1 - 100 is accepted ");
						msg.setSeverity(FacesMessage.SEVERITY_ERROR);
						 throw new ValidatorException(msg);
					
					
				}
	}

}
