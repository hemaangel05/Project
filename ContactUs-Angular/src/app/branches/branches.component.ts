import { Component, OnInit } from '@angular/core';
import { Branch } from '../model/branch';
import { InventoryService } from '../Service/inventory.service';


@Component({
  selector: 'app-branches',
  templateUrl: './branches.component.html',
  styleUrls: ['./branches.component.css']
})
export class BranchesComponent implements OnInit {


  branches:Branch[];
  constructor(private inv:InventoryService) { }

  ngOnInit() {
  this.branches=this.inv.getAllBranches();
  }


}
