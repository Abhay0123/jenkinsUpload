const { defineConfig } = require("cypress");


 async function setupNodeEvents(on, config) {

 
  
      // implement node event listeners here
      return config;
    }
module.exports = defineConfig({
 
  e2e: {
    
    setupNodeEvents,
    //for js file
    specPattern:'cypress/integration/example/Alias&invoke.js',
   
    env:{
       
    }
  },

  chromeWebSecurity : false
});
