package by.it_academy.TravelAgency.commands.factory;

import by.it_academy.TravelAgency.commands.Command;
import by.it_academy.TravelAgency.commands.admin.*;
import by.it_academy.TravelAgency.commands.guest.*;
import by.it_academy.TravelAgency.commands.user.*;

public enum CommandType {
    //guest commands
    LOGIN, LOGOUT, REGISTRATION, BACK, GO_TO_REGISTRATION,

    //user command
    GO_TO_MAIN_USER, GO_TO_SELECT_TOUR, SELECT_TOUR, RESERVE, GO_TO_RESERVED_TOURS, CANCEL_RESERVATION,

    //admin command
    GO_TO_MAIN_ADMIN, GO_TO_CREATE_TOUR, CREATE_TOUR, GO_TO_SET_DISCOUNT, SET_DISCOUNT;

    public Command getCurrentCommand() {
        switch (this) {
            case LOGIN:
                return new LoginCommand();

            case LOGOUT:
                return new LogoutCommand();

            case REGISTRATION:
                return new RegistrationCommand();

            case BACK:
                return new GoBackCommand();

            case GO_TO_REGISTRATION:
                return new GoToRegistrationCommand();

            case GO_TO_MAIN_ADMIN:
                return new GoToMainAdminCommand();

            case GO_TO_MAIN_USER:
                return new GoToMainUserCommand();

            case GO_TO_SELECT_TOUR:
                return new GoToSelectTourCommand();

            case SELECT_TOUR:
                return new SelectTourCommand();

            case GO_TO_CREATE_TOUR:
                return new GoToCreateTourCommand();

            case CREATE_TOUR:
                return new CreateTourCommand();

            case RESERVE:
                return new ReserveCommand();

            case GO_TO_RESERVED_TOURS:
                return new GoToReservedToursCommand();

            case CANCEL_RESERVATION:
                return new CancelReservationCommand();

            case GO_TO_SET_DISCOUNT:
                return new GoToSetDiscountCommand();

            case SET_DISCOUNT:
                return new SetDiscountCommand();

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
