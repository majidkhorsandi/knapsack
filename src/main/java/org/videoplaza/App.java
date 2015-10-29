package org.videoplaza;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.videoplaza.resources.BookingResource;

/**
 * Hello world!
 *
 */
public class App extends Application<Config> {

   public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

   @Override
   public String getName() {
      return "DropWizard test engineer assignment!!!!";
   }

   // Config before App runs
   @Override
   public void initialize(Bootstrap<Config> bootstrap) {

   }

   @Override
   public void run(Config configuration, Environment environment) {

      final BookingResource bookingResource = new BookingResource(

      );
      environment.jersey().register(bookingResource);
   }
}
