Part C - (mainscreen.html): Changed the head title and the HTML body h1 to "Abdul's PC Shop." Changed the first h2 to "PC Parts" and the second h2 to "Fully Built PCs."

Part D - (mainscreen.html, about.html, AboutController.java): Created about.html to describe Abdul's PC Shop. Added navigation link from mainscreen.html to the About page and added navigation link from about.html back to the main screen. Created AboutController.java with @Controller annotation and @GetMapping("/about") to map the About page.

Part E - (BootStrapData.java): Added five sample parts (CPU, GPU, RAM, Motherboard, SSD) and five sample products (Gaming PC, Office PC, Budget PC, Streaming PC, Workstation PC). Implemented conditional logic using partRepository.count() and productRepository.count() to ensure the sample inventory is only added when both the part and product lists are empty to prevent overwriting or duplicating existing data.

Part F - (mainscreen.html, BuyProductController.java, purchaseSuccess.html, purchaseError.html):
Added a "Buy Now" button next to the Update and Delete buttons in the products table. Implemented BuyProductController.java with @PostMapping("/buyProduct") to decrement product inventory by one when inventory is greater than zero without affecting associated parts. Added purchaseSuccess.html and purchaseError.html to display messages indicating purchase success or failure.

Part G - (Part.java, BootStrapData.java, InhousePartForm.html, OutsourcedPartForm.html, AddInhousePartController.java, AddOutsourcedPartController.java, application.properties):
Added minimum and maximum inventory fields to the Part entity including constructors, getters, setters, and validation method. Modified sample inventory in BootStrapData.java to include min and max values. Updated both part forms to allow user input for minimum and maximum inventory. Updated both part controllers to enforce inventory validation between minimum and maximum values. Renamed persistent H2 database file and updated application.properties to reflect new file name.

Part H - (AddInhousePartController.java, AddOutsourcedPartController.java, EnufPartsValidator.java): Updated part validation to display specific error messages when inventory is less than the minimum value and when inventory exceeds the maximum value. Modified EnufPartsValidator.java to prevent product updates that would cause associated part inventory to fall below its minimum level. Updated validation logic to enforce minimum inventory constraints when increasing product quantity.

Part I - (PartTest.java): Added two unit tests to verify the minimum and maximum inventory fields. Implemented getMinInv() and getMaxInv() tests using assertEquals to confirm correct getter and setter functionality for both InhousePart and OutsourcedPart.

Part J - (Part.java, DeletePartValidator.java, ValidDeletePart.java): Removed unused DeletePartValidator and ValidDeletePart classes. Removed @ValidDeletePart annotation and corresponding import from Part.java to clean up unused validation code.