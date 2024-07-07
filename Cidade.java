public enum Cidade {
    ARACAJU,
    BELEM,
    BELO_HORIZONTE,
    BOA_VISTA,
    BRASILIA,
    CAMPO_GRANDE,
    CUIABA,
    CURITIBA,
    FLORIANOPOLIS,
    FORTALEZA,
    GOIANIA,
    JOAO_PESSOA,
    MACAPA,
    MACEIO,
    MANAUS,
    NATAL,
    PALMAS,
    PORTO_ALEGRE,
    PORTO_VELHO,
    RECIFE,
    RIO_BRANCO,
    RIO_DE_JANEIRO,
    SALVADOR,
    SAO_LUIS,
    SAO_PAULO,
    TERESINA,
    VITORIA;

    @Override
    public String toString() {
        String name = name().replace('_', ' ').toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
