package com.veterinaria.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dtos.MascotaDto;
import com.veterinaria.entities.Dueño;
import com.veterinaria.entities.Mascota;
import com.veterinaria.entities.Veterinario;
import com.veterinaria.repository.DueñoRepository;
import com.veterinaria.repository.MascotaRepository;
import com.veterinaria.repository.VeterinarioRepository;

@Service
public class MascotaService {
	@Autowired
	 private VeterinarioRepository veterinarioRepository;
	
	@Autowired
	private DueñoRepository dueñoRepository;
	
    @Autowired
    private MascotaRepository mascotaRepository;

    
    public Mascota crearMascota(MascotaDto mascotaDto) {
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaDto.getNombre());
        mascota.setEdad(mascotaDto.getEdad());
        mascota.setRaza(mascotaDto.getRaza());
        mascota.setSexo(mascotaDto.getSexo());
        mascota.setPeso(mascotaDto.getPeso());
        mascota.setImagen(mascotaDto.getImagen());

        // Obtener el veterinario y asignarlo a la mascota
        Veterinario veterinario = veterinarioRepository.findById(mascotaDto.getIdVeterinario()).orElse(null);
        mascota.setVeterinario(veterinario);

        // Obtener el dueño y asignarlo a la mascota
        Dueño dueno = dueñoRepository.findById(mascotaDto.getIdDueno()).orElse(null);
        mascota.setDueño(dueno);

        return mascotaRepository.save(mascota);
    }
    
    
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> findById(Long id) {
        return mascotaRepository.findById(id);
    }

    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }
    
    public Mascota findMascotaByCitaId(Long idCita) {
        return mascotaRepository.findMascotaByCitaId(idCita);
    }
    
   

}