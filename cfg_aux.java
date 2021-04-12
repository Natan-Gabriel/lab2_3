public Tema addTema(Tema tema){
1        System.out.println("Service.addTema is called");
        temaValidator.validate(tema);
        return temaFileRepository.save(tema);
}

public void validate(Tema entity) throws ValidationException {
2    if(entity.getID().equals("") || entity.getID() == null) {
3        throw new ValidationException("Numar tema invalid!");
    }
4    if(entity.getDescriere().equals("")){
5        throw new ValidationException("Descriere invalida!");
    }
6    if(entity.getDeadline() < 1 || entity.getDeadline() > 14) {
7       throw new ValidationException("Deadlineul trebuie sa fie intre 1-14.");
    }
8    if(entity.getPrimire() < 1 || entity.getPrimire() > 14) {
9        throw new ValidationException("Saptamana primirii trebuie sa fie intre 1-14.");
    }
}

public E save(E entity) {
10    E entity1 = super.save(entity);
11    if (entity1 == null) {
12        saveToFile(entity);
    }

13    return entity1;
}

public E save(E entity) {
    E el = this.findOne(entity.getID());
    if (el==null){
        this.elemente.put(entity.getID(), entity);
        return null;
    }
    else return entity;

}

public E findOne(ID id) {
    return this.elemente.get(id);
}

public void saveToFile(E entity){
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {
        bufferedWriter.write(entity.toString());
        bufferedWriter.newLine();
    } catch (IOException exception) {
        throw new ValidationException(exception.getMessage());
    }
}

