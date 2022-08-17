#include "supervisormenu.h"
#include "ui_supervisormenu.h"

SupervisorMenu::SupervisorMenu(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::SupervisorMenu)
{
    ui->setupUi(this);
}

SupervisorMenu::~SupervisorMenu()
{
    delete ui;
}
