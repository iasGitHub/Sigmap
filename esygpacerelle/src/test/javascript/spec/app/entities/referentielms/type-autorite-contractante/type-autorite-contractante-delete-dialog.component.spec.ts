import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GatewaysigmapTestModule } from '../../../../test.module';
import { MockEventManager } from '../../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../../helpers/mock-active-modal.service';
import { TypeAutoriteContractanteDeleteDialogComponent } from 'app/entities/referentielms/type-autorite-contractante/type-autorite-contractante-delete-dialog.component';
import { TypeAutoriteContractanteService } from 'app/entities/referentielms/type-autorite-contractante/type-autorite-contractante.service';

describe('Component Tests', () => {
  describe('TypeAutoriteContractante Management Delete Component', () => {
    let comp: TypeAutoriteContractanteDeleteDialogComponent;
    let fixture: ComponentFixture<TypeAutoriteContractanteDeleteDialogComponent>;
    let service: TypeAutoriteContractanteService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GatewaysigmapTestModule],
        declarations: [TypeAutoriteContractanteDeleteDialogComponent],
      })
        .overrideTemplate(TypeAutoriteContractanteDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(TypeAutoriteContractanteDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(TypeAutoriteContractanteService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
