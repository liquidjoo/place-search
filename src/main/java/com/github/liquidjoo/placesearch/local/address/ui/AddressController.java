package com.github.liquidjoo.placesearch.local.address.ui;

import com.github.liquidjoo.placesearch.local.address.application.AddressResponse;
import com.github.liquidjoo.placesearch.local.address.application.AddressService;
import com.github.liquidjoo.placesearch.local.address.domain.Keyword;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(final AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(value = "query") String query,
                               @PageableDefault(size = 5) Pageable pageable) {
        try {
            final AddressResponse response = addressService.search(new Keyword(query));
            return new ResponseEntity<>(response.getAddressDocumentsByPaging(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
