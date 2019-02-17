package com.example.demo.controller;

import com.example.demo.model.MvtNoteLine;
import com.example.demo.model.Produit;
import com.example.demo.repository.MvtNoteLineRepository;
import com.example.demo.repository.ProoduitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MvtNoteLineController {

    private final Logger log = LoggerFactory.getLogger( MvtNoteLineController.class );

    private final MvtNoteLineRepository mvtNoteLineRepository;
    private final ProoduitRepository prooduitRepository;

    public MvtNoteLineController(MvtNoteLineRepository mvtNoteLineRepository, ProoduitRepository prooduitRepository) {
        this.mvtNoteLineRepository = mvtNoteLineRepository;
        this.prooduitRepository = prooduitRepository;
    }


    @PostMapping("/mvt-note-lines")
    public ResponseEntity<MvtNoteLine> createMvtNoteLine(@Valid @RequestBody MvtNoteLine mvtNoteLine) throws URISyntaxException {
        log.debug( "REST request to save MvtNoteLine : {}", mvtNoteLine );
        if (mvtNoteLine.getId() != null) {
            return ResponseEntity.badRequest().body( mvtNoteLine );
        }
        MvtNoteLine result = mvtNoteLineRepository.save( mvtNoteLine );
        return ResponseEntity.created( new URI( "/api/mvt-note-lines/" + result.getId() ) )
                .body( result );
    }


    /**
     * GET  /mvt-note-lines : get all the mvtNoteLines.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of mvtNoteLines in body
     */
    @GetMapping("/mvt-note-lines")
    public List<MvtNoteLine> getAllProduit() {
        log.debug( "REST request to get all MvtNoteLines" );
        return mvtNoteLineRepository.findAll();
    }


    @PostMapping("/produits")
    public ResponseEntity<Produit> createMvtNoteLine(@Valid @RequestBody Produit produit) throws URISyntaxException {
        log.debug( "REST request to save MvtNoteLine : {}", produit );
        if (produit.getId() != null) {
            return ResponseEntity.badRequest().body( produit );
        }
        Produit result = prooduitRepository.save( produit );
        return ResponseEntity.created( new URI( "/api/produit/" + result.getId() ) )
                .body( result );
    }


    /**
     * GET  /mvt-note-lines : get all the mvtNoteLines.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of mvtNoteLines in body
     */
    @GetMapping("/produits")
    public List<Produit> getAllMvtNoteLines() {
        log.debug( "REST request to get all MvtNoteLines" );
        return prooduitRepository.findAll();
    }


    @GetMapping("/get-lines")
    public List<MvtNoteLine> getLines() {
        log.debug( "REST request to get all MvtNoteLines" );
        return mvtNoteLineRepository.getLines();
    }

    @GetMapping("/init")
    @Transactional()
    public List<MvtNoteLine> init() {
        log.debug( "REST request to get all MvtNoteLines" );
        List<Produit> produits = new ArrayList<>();
        produits.add( new Produit().name( "Pr1" ) );
        produits.add( new Produit().name( "Pr2" ) );
        produits.add( new Produit().name( "Pr3" ) );
        produits.add( new Produit().name( "Pr4" ) );
        produits.add( new Produit().name( "Pr5" ) );
        prooduitRepository.saveAll( produits );
        List<MvtNoteLine> mvtNoteLines = new ArrayList<>();
        mvtNoteLines.add( new MvtNoteLine().line( "A" ).proId( 1L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "B" ).proId( 1L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "C" ).proId( 1L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "D" ).proId( 2L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "E" ).proId( 2L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "F" ).proId( 2L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "G" ).proId( 3L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "H" ).proId( 3L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "I" ).proId( 3L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "J" ).proId( 4L ) );
        mvtNoteLines.add( new MvtNoteLine().line( "K" ).proId( 4L ) );
        mvtNoteLineRepository.saveAll(mvtNoteLines  );

        return mvtNoteLineRepository.getLines();
    }


}
