/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author OS
 */
@Controller
public class controller {
    @RequestMapping("/profile")
    public String getProfile(@RequestParam(value="namaPeserta") String namePeserta,
                             @RequestParam(value="tglLahir") String tglLahirpeserta,
                             @RequestParam(value="foto")MultipartFile iFoto,
                             Model model)
    throws IOException{
        byte[] pict = iFoto.getBytes();
        String img = Base64.encodeBase64String(pict);
        String image ="data:image/png;base64,".concat(img);
        model.addAttribute("namaP", namePeserta);
        model.addAttribute("tglP", tglLahirpeserta);
        model.addAttribute("ifoto", image);
        
        return "main";
        
    }
}
