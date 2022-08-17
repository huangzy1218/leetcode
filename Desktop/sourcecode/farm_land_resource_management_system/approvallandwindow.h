#ifndef APPROVALLANDWINDOW_H
#define APPROVALLANDWINDOW_H

#include <QWidget>

namespace Ui {
class ApprovalLandWindow;
}

class ApprovalLandWindow : public QWidget
{
    Q_OBJECT

public:
    explicit ApprovalLandWindow(QWidget *parent = nullptr);
    ~ApprovalLandWindow();

private:
    Ui::ApprovalLandWindow *ui;
};

#endif // APPROVALLANDWINDOW_H
