package PrimesniperTechSolutions.Primesniper;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(path="api/v1/Sniper")
@AllArgsConstructor
public class SniperController {

    SniperService sniperService;

    @GetMapping("/index")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/getAll")
    public List <Sniper> getAllSnipers(){

        return sniperService.getAllSnipers();
    }

    @GetMapping("/getById/{id}")
    public Optional <Sniper> getById(@PathVariable("id") Long id){
        return  sniperService.getBySniperId(id);
    }

    @PostMapping("/addSniper")
    public ResponseEntity<Object> addSniper(@RequestBody Sniper sniper) {
         sniperService.addSniper(sniper);
        return ResponseEntity.ok("Sniper added successfully: ");
    }

    @PutMapping("/update")
    public ResponseEntity updateSniper(@RequestBody Sniper sniper){
        Optional <Sniper> existingSniper = sniperService.getBySniperId(sniper.getId());

        if (existingSniper.isPresent()) {
            Sniper updatedSniper = existingSniper.get();
            updatedSniper.setUsername(sniper.getUsername());
            updatedSniper.setEmail(sniper.getEmail());
            updatedSniper.setPassword(sniper.getPassword());
            updatedSniper.setMsisdn(sniper.getMsisdn());

            sniperService.updateSniper(updatedSniper);

            return ResponseEntity.ok("Sniper Updated Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSniper(@PathVariable("id") Long id){
        sniperService.deleteSniper(id);
        return ResponseEntity.ok("Sniper deleted");
    }

}
