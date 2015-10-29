package org.videoplaza;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class Config extends Configuration {

   @NotEmpty
   private String template;

   @JsonProperty
   public String getTemplate() {
      return template;
   }

   @JsonProperty
   public void setTemplate(String template) {
      this.template = template;
   }
}
