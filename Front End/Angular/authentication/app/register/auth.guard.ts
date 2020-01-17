import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate {
    canActivate(router: ActivatedRouteSnapshot): boolean {
        const expectedRolesArray = router.data.expectedRoles;
        const userDetails = JSON.parse(localStorage.getItem('userDetails'));
        let expectedRole: string;

        for(const index in expectedRolesArray) {
            if(userDetails && userDetails.product.role === expectedRolesArray[index]) {
                expectedRole = expectedRolesArray[index];
            }
        }
        if(userDetails && userDetails.product.role === expectedRole) {
            return true;
        } else {
            return false;
        }
    }
}
