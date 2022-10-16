package com.g15.jpa.service;

import com.g15.jpa.dto.CountClient;
import com.g15.jpa.dto.StatusAmount;
import com.g15.jpa.entity.Client;
import com.g15.jpa.entity.Reservation;
import com.g15.jpa.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desaextremo
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //Metodo para consultar todos los registros (Capa de servicios)
    public List<Reservation> getReservation() {
        return reservationRepository.findAll();
    }

    //Metodo para insertar (Capa de servicios)
    public Reservation insertReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //Metodo para consultar una registo x su id (Capa de servicios)
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    //Metodo para eliminar (Capa de servicios)
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation updateReservation(Reservation reservation) {
        //la farm existe
        if (reservation.getIdReservation() != null) {
            //validamos si la Reservation existe
            Optional<Reservation> opcional = reservationRepository.findById(reservation.getIdReservation());

            //la farm no existe
            if (opcional.isEmpty()) {
                return reservation;
            } //si la farm existe
            else {
                Reservation reservDB = opcional.get();

                if (reservation.getStartDate() != null) {
                    reservDB.setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservDB.setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getClient() != null) {
                    reservDB.setClient(reservation.getClient());
                }
                if (reservation.getFarm() != null) {
                    reservDB.setFarm(reservation.getFarm());
                }

                return reservationRepository.save(reservDB);
            }

        }
        return reservation;
    }

    public List<Reservation> getReservationByDates(String fUno, String fDos) {

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(fUno);
            b = parser.parse(fDos);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservationRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<Reservation> getReservationByRange(String fUno, String fDos) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(fUno);
            b = parser.parse(fDos);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservationRepository.findAllByStartDateBetween(a, b);
    }

    public StatusAmount getReservationsStatusReport() {
        List<Reservation> completed = reservationRepository.findAllByStatus("completed");
        List<Reservation> cancelled = reservationRepository.findAllByStatus("cancelled");
        return new StatusAmount(completed.size(), cancelled.size());

    }

    public List<CountClient> getTopClients() {
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationRepository.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }

}
