#ifndef SUPERVISORMENU_H
#define SUPERVISORMENU_H

#include <QWidget>

namespace Ui {
class SupervisorMenu;
}

class SupervisorMenu : public QWidget
{
    Q_OBJECT

public:
    explicit SupervisorMenu(QWidget *parent = nullptr);
    ~SupervisorMenu();

private:
    Ui::SupervisorMenu *ui;
};

#endif // SUPERVISORMENU_H
