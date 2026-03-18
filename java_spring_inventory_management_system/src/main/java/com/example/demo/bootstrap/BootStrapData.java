package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        // List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        // for(OutsourcedPart part:outsourcedParts){
        //     System.out.println(part.getName()+" "+part.getCompanyName());
        // }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        long partCount = partRepository.count();
        long productCount = productRepository.count();

        if (partCount == 0 && productCount == 0) {

            // Parts
            OutsourcedPart cpu = new OutsourcedPart();
            cpu.setName("CPU");
            cpu.setPrice(250.00);
            cpu.setInv(10);
            cpu.setMinInv(1);
            cpu.setMaxInv(20);
            cpu.setCompanyName("Intel");
            outsourcedPartRepository.save(cpu);

            OutsourcedPart gpu = new OutsourcedPart();
            gpu.setName("GPU");
            gpu.setPrice(500.00);
            gpu.setInv(8);
            gpu.setMinInv(1);
            gpu.setMaxInv(15);
            gpu.setCompanyName("Nvidia");
            outsourcedPartRepository.save(gpu);

            OutsourcedPart ram = new OutsourcedPart();
            ram.setName("RAM");
            ram.setPrice(120.00);
            ram.setInv(15);
            ram.setMinInv(5);
            ram.setMaxInv(30);
            ram.setCompanyName("Corsair");
            outsourcedPartRepository.save(ram);

            OutsourcedPart motherboard = new OutsourcedPart();
            motherboard.setName("Motherboard");
            motherboard.setPrice(180.00);
            motherboard.setInv(7);
            motherboard.setMinInv(1);
            motherboard.setMaxInv(10);
            motherboard.setCompanyName("ASUS");
            outsourcedPartRepository.save(motherboard);

            OutsourcedPart ssd = new OutsourcedPart();
            ssd.setName("SSD");
            ssd.setPrice(100.00);
            ssd.setInv(20);
            ssd.setMinInv(5);
            ssd.setMaxInv(40);
            ssd.setCompanyName("Samsung");
            outsourcedPartRepository.save(ssd);

            // Products
            Product gamingPC = new Product("Gaming PC", 1500.00, 5);
            Product officePC = new Product("Office PC", 900.00, 4);
            Product budgetPC = new Product("Budget PC", 700.00, 6);
            Product streamingPC = new Product("Streaming PC", 1300.00, 3);
            Product workstationPC = new Product("Workstation PC", 2000.00, 2);

            productRepository.save(gamingPC);
            productRepository.save(officePC);
            productRepository.save(budgetPC);
            productRepository.save(streamingPC);
            productRepository.save(workstationPC);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}