
describe('Aliases and invoke', () => {
    it('Aliases and invoke', () => {
        cy.visit('https://automationteststore.com/');
        cy.get("a[href*='product/category&path=']").contains('Hair Care').click();
        cy.get('.prdocutname').eq(0).invoke("text").as("ItemPro");
        // i want to check the length of the text is greater than 5
        cy.get('@ItemPro').its('length').should('be.gt',5)
        cy.get('@ItemPro').should('include','Seaweed Conditioner')

    });

    it.only("Example 2", ()=>{
        // find products 
        // use aliases and use .should ==> length = 16  
        cy.visit('https://automationteststore.com/');
        cy.get('.thumbnail').as('allproducts')
        cy.get('@allproducts').should('have.length',16)
        // alias name // can we continue to identify 
        cy.get('@allproducts').find('.productcart').invoke('attr','title').should('include','Add to Cart');

    })
});