package br.com.porygon;

public class RegistroManual extends Registro {
    private Double temp = null;
    private Double umi = null;
    private Double pressao = null;
    private Double nebulosidade = null;
    private Double insolacao = null;
    private Double tempMax = null;
    private Double tempMin = null;
    private Double chuva = null;

    public Double converterEscala(Double tempInst) {
        // Obtém a temperatura da instância atual de RegistroAutomatico
        if(tempInst != null){
            double temperaturaCelsius = tempInst - 273.15;
            return temperaturaCelsius;
        }
        return null;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getUmi() {
        return umi;
    }

    public void setUmi(Double umi) {
        this.umi = umi;
    }

    public Double getPressao() {
        return pressao;
    }

    public void setPressao(Double pressao) {
        this.pressao = pressao;
    }

    public Double getNebulosidade() {
        return nebulosidade;
    }

    public void setNebulosidade(Double nebulosidade) {
        this.nebulosidade = nebulosidade;
    }

    public Double getInsolacao() {
        return insolacao;
    }

    public void setInsolacao(Double insolacao) {
        this.insolacao = insolacao;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getChuva() {
        return chuva;
    }

    public void setChuva(Double chuva) {
        this.chuva = chuva;
    }

    public RegistroManual(String data, String hora, Double velVento, Double dirVento, Double temp, Double umi,
            Double pressao, Double nebulosidade, Double insolacao, Double tempMax, Double tempMin, Double chuva) {
        super(data, hora, velVento, dirVento);
        this.temp = temp;
        this.umi = umi;
        this.pressao = pressao;
        this.nebulosidade = nebulosidade;
        this.insolacao = insolacao;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.chuva = chuva;
        setTemperatura(converterEscala(temp));
    }
}