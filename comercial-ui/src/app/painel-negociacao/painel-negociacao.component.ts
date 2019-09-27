import { OportunidadeService } from './../oportunidade.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-painel-negociacao',
  templateUrl: './painel-negociacao.component.html',
  styleUrls: ['./painel-negociacao.component.css']
})
export class PainelNegociacaoComponent implements OnInit {

  nome = '';
  oportunidades = [];
  oportunidade = {};

  constructor(private oportunidadeService: OportunidadeService) { }

  ngOnInit()
  {
    this.consultar();
  }

  consultar() {
    //assim que o método obtivewr resposta, eu atribuo a 'resposta', e então utilizo essa 'resposta como necessario'
    this.oportunidadeService.listar().subscribe(
      resposta => this.oportunidades = <any>resposta)
  }

  adicionar()
  {
    return this.oportunidadeService.adicionar(this.oportunidade).subscribe(
      () => {
        this.oportunidade = {};
        this.consultar();
      }
    ) 
  }

}
